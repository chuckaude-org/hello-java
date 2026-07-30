// https://documentation.blackduck.com/bundle/coverity-docs/page/checker-ref/checkers/NO/os_cmd_injection.html

import java.io.*;
import javax.servlet.http.HttpServletRequest;

public class CommandInjection {
    public static Process runCmd(HttpServletRequest request) throws IOException {
        String command = request.getParameter("command");
        ProcessBuilder builder = new ProcessBuilder("sh", command);
        Process process = builder.start();
        return(process);
    }
}
