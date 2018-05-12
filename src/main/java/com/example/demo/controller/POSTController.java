package com.example.demo.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.List;

import com.example.demo.models.*;
import com.example.demo.services.NotificationService;
import com.example.demo.services.PostService;
import com.example.demo.services.UserService;
import com.example.demo.util.PostAndComment;
import com.example.demo.util.UtilityClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class POSTController {

	@Value("${AWSAPIKEY}")
	String apiKey;
	
	@Value("${AWSSECRETKEY}")
	String secretKey;
	
	
	@Value("${BUCKETNAME}")
	String bucketName;

	@Autowired
	private UserService userService;

	@Autowired
	private PostService postService;

	@Autowired
	private NotificationService notificationService;


	UtilityClass utilityClass = new UtilityClass();

	@PostMapping(value = "/upload")
	public ModelAndView uploadtoS3(@RequestParam("file") MultipartFile image) {
		ModelAndView profilePage = new ModelAndView();
		BasicAWSCredentials cred = new BasicAWSCredentials(apiKey,
				secretKey);
		AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(cred))
				.withRegion(Regions.US_EAST_2).build();
		try {
			PutObjectRequest putReq = new PutObjectRequest(bucketName, image.getOriginalFilename(),
					image.getInputStream(), new ObjectMetadata()).withCannedAcl(CannedAccessControlList.PublicRead);

			s3Client.putObject(putReq);

			String imgSrc = "http://" + bucketName + ".s3.amazonaws.com/" + image.getOriginalFilename();
			profilePage.addObject("imgSrc", imgSrc);

			profilePage.setViewName("profile");
			return profilePage;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			profilePage.setViewName("/error");
			return profilePage;
		}
	}
    @GetMapping(value = "/audioRecorder")
    public ModelAndView renderAudioPage(HttpServletRequest request){
        return new ModelAndView("record_audio");
    }

    @PostMapping(value = "/savePost")
    public ModelAndView saveAudioFile(HttpServletRequest request,
                                      @RequestParam("recording") String recording,
									  @RequestParam("imageFileUrl") String imageUrl) throws Exception{

		HttpSession session = request.getSession();
		String audioFileUrl = "";
		String username = (String) session.getAttribute("username");
	    ModelAndView modelAndView = new ModelAndView();
		String fileURI = null;
	    if(recording.isEmpty()) throw new Exception("recording data is null");
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decodedByte = decoder.decode(recording.split(",")[1]);
        FileOutputStream fos;
        try{
            fos = new FileOutputStream("postAudio.webm");
            fos.write(decodedByte);


			BasicAWSCredentials cred = new BasicAWSCredentials(apiKey,
					secretKey);
			AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(cred))
					.withRegion(Regions.US_EAST_2).build();

			PutObjectRequest putReq = new PutObjectRequest(bucketName, utilityClass.uniqueTimeStamp()+username+".webm",
					new FileInputStream("postAudio.webm"), new ObjectMetadata()).withCannedAcl(CannedAccessControlList.PublicRead);

			s3Client.putObject(putReq);
			fileURI = "http://"+bucketName+".s3.amazonaws.com/"+utilityClass.uniqueTimeStamp()+username+".webm";


        }catch (Exception e){
            e.printStackTrace();
        }
		Post post = new Post();
		post.setImageUrl(imageUrl);
        post.setAudioUrl(fileURI);
        post.setTimestamp(utilityClass.uniqueTimeStamp());
        Users users = userService.findUserByName(username);
        post.setUserId(users.getId());
        post.setTextCaption("");
        postService.savePosts(post);


		sendNotificationToUserPost(post,users,"New Post Added By "+users.getUsername(),false);

		modelAndView.setViewName("drawer");
		return modelAndView;


    }

	private void sendNotificationToUserPost(Post post, Users users, String s, boolean b) {

		List<Friends> friendsList = userService.getFriendByUsername(users.getId());
		for (int i=0;i<friendsList.size();i++){
			Notifications notifications = new Notifications();
			notifications.setPostId(post.getId());
			notifications.setUserId(users.getId());
			notifications.setMessage(s);
			notifications.setVisited(b);
			notifications.setToBeNotified(friendsList.get(i).getFriendId());
			notificationService.saveNotification(notifications);
		}

	}


	@PostMapping(value = "/saveImage")
    public ModelAndView saveAndRenderImage(HttpServletRequest request,
                                           @RequestParam("image") String image
										   ) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
		HttpSession session = request.getSession();
		String fileURI = null;
		String username = (String) session.getAttribute("username");
		String imageFileUrl = null;
		if(image.isEmpty()) throw new Exception("image data is null");
		Base64.Decoder decoder = Base64.getDecoder();
		byte[] decodedByte = decoder.decode(image.split(",")[1]);
		FileOutputStream fos;
		try{
			fos = new FileOutputStream("postImage.png");
			fos.write(decodedByte);

			BasicAWSCredentials cred = new BasicAWSCredentials(apiKey,
					secretKey);
			AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(cred))
					.withRegion(Regions.US_EAST_2).build();

			PutObjectRequest putReq = new PutObjectRequest(bucketName, utilityClass.uniqueTimeStamp()+".png",
					new FileInputStream("postImage.png"), new ObjectMetadata()).withCannedAcl(CannedAccessControlList.PublicRead);

			s3Client.putObject(putReq);
			fileURI = "http://"+bucketName+".s3.amazonaws.com/"+utilityClass.uniqueTimeStamp()+".png";



			fos.close();
		}catch (Exception e){
			e.printStackTrace();
		}
		System.out.println(fileURI);
		modelAndView.addObject("image",imageFileUrl);
		modelAndView.setViewName("redirect:/audioRecorder");
        System.out.println(image);
        return modelAndView;
    }

    @GetMapping(value = "/captureImage")
    public ModelAndView renderCaptureImagePage(HttpServletRequest request){
	    return new ModelAndView("captureImage");
    }

    @GetMapping(value = "/view_timeline")
    public ModelAndView getFriendsPostByUser(HttpServletRequest request){

		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		ModelAndView modelAndView = new ModelAndView();
		Users user = userService.findUserByName(username);

		List<Friends> friendsList = userService.getFriendByUsername(user.getId());
		List<Post> postList = new ArrayList<>();
		for (int i=0;i<friendsList.size();i++){
			postList.addAll(postService.getPostByUserId(friendsList.get(i).getFriendId()));
		}

		Collections.sort(postList,new Post());
		modelAndView.addObject("postList",postList);
		return modelAndView;

	}


	@GetMapping(value = "/myPosts")
	public ModelAndView getMyPosts(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		Users users = userService.findUserByName(username);
		List<Post> postList = new ArrayList<>();
		postList = postService.getPostByUserId(users.getId());
		Collections.sort(postList,new Post());
		modelAndView.addObject("postList",postList);
		modelAndView.setViewName("mypost");
		return modelAndView;
	}




	@GetMapping(value = "/viewSinglePost")
	public ModelAndView viewSinglePost(HttpServletRequest request,
									   @RequestParam("postId") String postId){
		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");

		Integer id =  Integer.parseInt(postId);
		Post post = postService.getPostById(id);

		modelAndView.addObject("post",post);

		List<Comment> commentList = postService.getCommentByPostId(post.getId());

		PostAndComment postAndComment = new PostAndComment();
		postAndComment.setPostId(post.getId());
		postAndComment.setImageUrl(post.getImageUrl());
		postAndComment.setAudioUrl(post.getAudioUrl());
		postAndComment.setTextCaption(post.getTextCaption());
		postAndComment.setComments(commentList);


		modelAndView.addObject("postAndComment",postAndComment);

		modelAndView.setViewName("view_single_post");
		return modelAndView;

	}



	@PostMapping(value = "/addComment")
	public ModelAndView addComment(HttpServletRequest request,
								   @RequestParam(name = "comment") String comment,
								   @RequestParam(name = "postId") String postID){

		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		int postId = Integer.parseInt(postID);
		Comment c = new Comment();
		c.setComments(comment);
		c.setPostId(postId);
		c.setUserName(username);
		postService.addComment(c);


		List<Comment> commentList = postService.getCommentByPostId(postId);
		List<Users> usersList = new ArrayList<>();
		for (int i=0;i<commentList.size();i++){
			usersList.add(userService.findUserByName(commentList.get(i).getUserName()));
		}



		Post post = postService.getPostById(postId);
		Users users = userService.findUserByName(username);
		sendNotificationToUser(post,usersList,1,"Comment Added",false);

		modelAndView.setViewName("redirect:/viewSinglePost?postId="+postId);
		return modelAndView;

	}


	private void sendNotificationToUser(Post post, List<Users> users,int var, String s, boolean b) {
		if(var == 1) {
			for (int i = 0; i < users.size(); i++) {
				Notifications notifications = new Notifications();
				notifications.setPostId(post.getId());
				notifications.setUserId(users.get(i).getId());
				notifications.setMessage(s);
				notifications.setVisited(b);
				notifications.setToBeNotified(users.get(i).getId());
				notificationService.saveNotification(notifications);
			}
		}else{

		}

	}



}
