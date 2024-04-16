import java.io.IOException;
import java.net.URI;

class Handler implements URLHandler {
    // 
    int num = 0;

    public String handleRequest(URI url) {
        if (url.getPath().contains("/add-message")) {
          //create empty variables to store the strings
          String stringToAdd = "";
          String userName = "";
          
          //split the string and the user name
          String[] parameters = url.getQuery().split("&");
          
          //split the two strings for the message and the username 
          String[] str = parameters[0].split("=");
          String[] user = parameters[1].split("=");
          
          // retrieve the string and username from str and user
          if (str[0].equals("s")){
            stringToAdd=str[1];
          }
          if(user[0].equals("user")){
            userName = user[1];
          }

          //concatenate
          return userName + ": "+stringToAdd+\n;
        }
        else{
          println("404 not found!")
        }

class ChatServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
