package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Controller {

    /*
    * Run command in bash and return value
    * */
    private String execCommand(String[] commandArr) {
        String line;
        String output ="";
        try
        {
            Process p = Runtime.getRuntime().exec(commandArr);
            BufferedReader stdoutReader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = stdoutReader.readLine()) != null) {
                // process procs standard output here
//                System.out.println(" .. stdout: "+line);
                output += "\n  "+line;
            }
            BufferedReader stderrReader = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            while ((line = stderrReader.readLine()) != null) {
                // process procs standard error here
//                System.err.println(" .. stderr: "+line);
                output += "\n .. stderr: "+line;
            }
            int retValue = p.waitFor();
//            System.out.println(" .. exit code:"+Integer.toString(retValue));
            output += "\n .. exit code:"+Integer.toString(retValue);
        }
        catch(Exception e)
        {
//            System.err.println(e.toString());
            output += e.toString();
        }

        return output;
    }



    //        Not a git repository
    public String gitRequest(String directory, String gitCommand){
        //what to run in the terminal
        String[] cmd = {
                "/bin/bash", "-c",
                "git -C " + directory + " "+ gitCommand +""
        };
        String returnText = execCommand(cmd);
        if (returnText.contains("Username:")){
            String[] cmd2 = {
                    "/bin/bash", "-c",
                    "warriv93"
            };
            returnText = execCommand(cmd);
        }else if (returnText.contains("Password:")){
            String[] cmd2 = {
                    "/bin/bash", "-c",
                    "jk75tdsd"
            };
            returnText = execCommand(cmd);
        }
        return returnText;
    }




}
