<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>Image-only Example - Record Plugin for Video.js</title>

    <link href="https://vjs.zencdn.net/6.6.3/video-js.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/videojs-record/2.1.0/css/videojs.record.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/video.js/6.7.2/video.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/RecordRTC/5.4.6/RecordRTC.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/adapterjs/0.15.0/adapter.min.js"></script>
    <script src="https://collab-project.github.io/videojs-record/dist/wavesurfer.min.js"></script>
    <script src="https://collab-project.github.io/videojs-record/dist/wavesurfer.microphone.min.js"></script>
    <script src="https://collab-project.github.io/videojs-record/dist/videojs.wavesurfer.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/videojs-record/2.1.2/videojs.record.min.js"></script>


    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <style>
        /* change player background color */
        #myImage {
            background-color: #efc3e6;
        }
    </style>
</head>
<body>



<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<video id="myImage" class="video-js vjs-default-skin"></video>

<script>
    var player = videojs("myImage", {
        controls: true,
        width: 320,
        height: 240,
        fluid: false,
        controlBar: {
            volumePanel: false,
            fullscreenToggle: false
        },
        plugins: {
            record: {
                image: true,
                debug: true
            }
        }
    }, function(){
        // print version information at startup
        videojs.log('Using video.js', videojs.VERSION,
            'with videojs-record', videojs.getPluginVersion('record'));
    });
    // error handling
    player.on('deviceError', function() {
        console.warn('device error:', player.deviceErrorCode);
    });
    player.on('error', function(error) {
        console.log('error:', error);
    });
    // snapshot is available
    player.on('finishRecord', function() {
        // the blob object contains the image data that
        // can be downloaded by the user, stored on server etc.
        console.log('snapshot ready: ', player.recordedData);

        $("#image").val(player.recordedData);
        });



    $(document).ready(function(){
        $("#saveButton").on("click",function(){
                 $("#saveImage").submit();
        })
    });
</script>





<label>Didn't Like your photo? Upload from your computer.</label>
<form id="saveImage" action="/saveImage" method="POST" enctype="multipart/form-data">
    <input type="hidden" id="image" name="image">
</form>


<label>Select an Annotation</label>
<div class="btn-group btn-group-toggle" data-toggle="buttons">
    <label class="btn btn-secondary active">
        <input type="radio" name="options" id="option1" autocomplete="off" checked> Text
    </label>
    <label class="btn btn-secondary">
        <input type="radio" name="options" id="option2" autocomplete="off"> Audio
    </label>
</div>

<button id="saveButton">Save</button>

</body>
</html>