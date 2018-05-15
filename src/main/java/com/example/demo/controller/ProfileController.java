package com.example.demo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.example.demo.models.Users;
import com.example.demo.services.UserService;
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
import com.example.demo.models.Profile;
import com.example.demo.services.ProfileService;

@Controller
public class ProfileController {
	
	@Autowired
	ProfileService service;

	@Autowired
	UserService userService;

	@Value("${AWSAPIKEY}")
	String apiKey;
	
	@Value("${AWSSECRETKEY}")
	String secretKey;
	
	
	@Value("${BUCKETNAME}")
	String bucketName;
	
	@PostMapping(value = "/createProfile")
	public ModelAndView createProfile(@RequestParam("file") MultipartFile image,
			@RequestParam("name") String name,
			@RequestParam("desc") String desc,
			HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		String username = (String) session.getAttribute("username");

		Users user = userService.findUserByName(username);


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

			Profile profile = new Profile();

			if (service.findProfile(username) != null){
				profile.setId(service.findProfile(username).getId());
			}

			profile.setName(name);
			profile.setProfileImageName(imgSrc);
			profile.setUsername(username);
			profile.setUserId(user.getId());
			profile.setDescription(desc);
			service.saveProfile(profile);

			profilePage.setViewName("redirect:/getProfile");


			return profilePage;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			profilePage.setViewName("/error");
			return profilePage;
		}
	}
	
	

	@GetMapping(value = "/getProfile")
	public ModelAndView getProfile(HttpServletRequest req) {
		HttpSession session = req.getSession();
		String username = (String) session.getAttribute("username");
		ModelAndView profilePageView = new ModelAndView();
		Profile profile = service.findProfile(username);
		
		profilePageView.addObject("profileImageName",profile.getProfileImageName());
		profilePageView.addObject("name",profile.getName());
		profilePageView.addObject("description",profile.getDescription());
		
		profilePageView.setViewName("profile");
		return profilePageView;
	}


}
