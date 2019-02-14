<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../jquery/jquery-3.2.1.min.js"></script>
    <script type="text/javascript">

        var ws;
        var target = "ws:localhost:80/chat333?username=" + '${username}';

        window.onload = function () {

            if ('WebSocket' in window) {
                ws = new WebSocket(target);
            } else if ('MozWebSocket' in window) {
                ws = new MozWebSocket(target);
            } else {
                alert('WebSocket is not supported by this browser.');
                return;
            }

            ws.onmessage=function(e){
                var obj = eval("["+e.data+"]")[0];
                var welcomeMsg = obj.welcomeMsg
                if (undefined!=welcomeMsg&&null!=welcomeMsg){
                    $("#content").append(welcomeMsg);
                }

                var names = obj.names;
                if (undefined!=names&&null!=names){
                    $("#userList").html("");
                    for(var i=0; i<names.length; i++){
                        $("#userList").append(names[i]+"<br />");
                    }
                }

                var content = obj.content;
                if (undefined!=content&&null!=content){
                    $("#content").append(content);
                }
            }

        };
        
        function send() {
            ws.send($("#sendMsg").val());
            $("#sendMsg").val("");
        }

    </script>
</head>
<body>
    <div style="border: black solid 1px; width: 600px; height: 500px;">
        <div id="content" style="border: black solid 1px; width: 450px; height: 400px; float: left;">

        </div>
        <div style="border: black solid 1px; width: 450px; height: 98px; float: left;">
            <input type="text" id="sendMsg" value="" />
            <input type="button" onclick="send()" value="send" />
        </div>

        <div id="userList" style="border: black solid 1px; width: 150px; height: 500px; margin-left: 450px;">

        </div>
    </div>
</body>
</html>
