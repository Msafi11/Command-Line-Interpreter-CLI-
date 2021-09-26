package assignment_OS_klaket_tany_mara;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class terminal {

	public static void pwd() {// it tells me where is the current path.
		
		String pwd = System.getProperty("user.dir");//built in function tells me where is the current path
		
		
		

		System.out.println("we are here now: " + pwd);

	}

	public static void ls() {  // it prints out the files in the current path or in the folder i choosed.
		File dir = new File(System.getProperty("user.dir"));
		String files[] = dir.list();// array of string to store in it the files in the folder and then list them all.

		System.out.println("files are in this path: ");

		for (String file : files) { // the string file belongs to the array files.

			System.out.println(file);

		}

	}

	public static void lsmore() {
		File dir = new File(System.getProperty("user.dir"));
		String files[] = dir.list(); // array of string to store in it the files in the folder and then list them all.
		Scanner newline = new Scanner(System.in);

		System.out.println("files are in this path: ");

		int count = 0;
		for (int i = 0; i < files.length; i++) {

			System.out.print(files[i] + " ");
			count += 1;

			if (count == 2) {

				String newl = newline.nextLine();
				if (newl == "")
					continue;
				count = 0;
			}

		}

	}

	public static void date() { // to print out the current date.
		DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"); // built in fuction gives me the format of the date i want to print.
		LocalDateTime now = LocalDateTime.now(); // tells me the current time from the system or the computer.
		System.out.println(date.format(now));
	}

	public static void help() { // informations about the  commands.
		System.out.println(
				"clear         This command can be called to clear the current terminal screen and it can be redirected to clear the screen of some other terminal.");
		System.out.println("cd            This command changes the current directory to another one.");
		System.out.println(
				"ls            These programs list each given file or directory name. Directory contents are sorted alphabetically. For ls, files are by default listed in columns, sorted vertically, if the standard output is a terminal; otherwise, they are listed one per line.");
		System.out.println("pwd           Display current user directory.");
		System.out.println(
				"cp            If the last argument names an existing directory, cp copies each other given file into a file with the same name in that directory. Otherwise, if only two files are given, it copies the first onto the second. It is an error if the last argument is not a directory and more than two files are given. By default, it does not copy directories.");
		System.out.println(
				"mv            If the last argument names an existing directory, mv moves each other given file into a file with the same name in that directory. Otherwise, if only two files are given, it moves the first onto the second. It is an error if the last argument is not a directory and more than two files are given. It can move only regular files across file systems. If a destination file is unwritable, the standard input is a tty, and the –f or --force option is not given, mv prompts the user for whether to overwrite the file. If the response does not begin with y or Y, the file is skipped.");
		System.out.println(
				"rm            rm removes each specified file. By default, it does not remove directories. If a file is unwritable, the standard input is a tty, and the -f or --force option is not given, rm prompts the user for whether to remove the file. If the response does not begin with y or Y, the file is skipped.");
		System.out.println(
				"mkdir         mkdir creates a directory with each given name. By default, the mode of created directories is 0777 minus the bits set in the umask.");
		System.out.println(
				"rmdir         rmdir removes each given empty directory. If any nonoption argument does not refer to an existing empty directory, it is an error.");
		System.out.println(
				"date          To display or to set the date and time of the system. The format for setting date is [MMDDhhmm[[CC]YY][.ss]]");
		System.out.println("echo          Prints its arguments to the screen.");
		System.out.println("cat           Concatenate files and print on the standard output.");
		System.out.println("uname         Gets name and information about the current kernel.");
		System.out.println("users         Displays the current users that are logged on the system.");
		System.out.println("who           Output who is logged in on local machines. Similar to users.");
		System.out.println(
				"pipeOperator  Redirect the output to be written to a file using the redirect > create/replace file operator");
		System.out.println(
				"RedirectOper  Redirect the output to be written to a file using the redirect >> create/append to file operator.");
		System.out.println("exit          quit the terminal.");
		System.out.println("help          list all commands.");
		System.out.println("pipe operator Redirect the input to be taken from a file.");

	}

	public static void who() {
		String uname = System.getProperty("user.name");// string that gets the username .
		System.out.println("user is logged in >> " + uname);
	}

	public static void uname() {
		String karnelname = System.getProperty("os.name"); // get the name of the os.
		String karnelversion = System.getProperty("os.version");// get the version of the os.
		String karnelarch = System.getProperty("os.arch");// get the arch of the os 64 or 32.


		System.out.println("windwos name >> " + karnelname);
		System.out.println("windwos version >> " + karnelversion);
		System.out.println("windwos arch >> " + karnelarch);

	}

	public static void users() { //print out all the available users
		String unames = System.getProperty("user.name");
		System.out.println("all users >> " + unames);
	}

	public static void clear() { //it prints spaces on the console like real terminal
		for (int i = 0; i < 50; ++i)
			System.out.println();
	}

	public static void cp(String sourcepath, String destinationpath) throws IOException {

		if (!sourcepath.contains(":")) { //if i wrote a short path it will transfer it handle it to current dir
			sourcepath = System.getProperty("user.dir") + "\\" + sourcepath;
		}
		if (!destinationpath.contains(":")) {// the same for the destination
			destinationpath = System.getProperty("user.dir") + "\\" + destinationpath;
		}

		InputStream is = null;//File Stream object
		OutputStream os = null;//Same

		is = new FileInputStream(sourcepath);// opened the file i want to copy
		os = new FileOutputStream(destinationpath);// the new file that i will copy in it the new one
		byte[] buffer = new byte[1024];// to store in it the content of the file
		int length;
		while ((length = is.read(buffer)) > 0) {//  check the file empty or not
			os.write(buffer, 0, length);  // zero to write from the beginning till the end of file
		}
		System.out.println("File is copied Successfully!!");

		is.close();
		os.close();
		// close the source and destination

	}

	public static void cd(String newpath) { // changes my current path
		if (!newpath.contains(":")) {
			newpath = System.getProperty("user.dir") + "\\" + newpath;
		}

		String here = System.getProperty("user.dir"); // my current path or location
		String cd = System.setProperty("user.dir", newpath); // the new path

	}

	public static void rm(String delfile) { // remove the file
		if (!delfile.contains(":")) {
			delfile = System.getProperty("user.dir") + "\\" + delfile;
		}

		File file = new File(delfile);

		if (file.delete()) {
			System.out.println("File deleted successfully");
		} else {
			System.out.println("Failed to delete the file");
		}

	}

	public static void mv(String sourcepath, String destinationpath) throws Exception {// moving file
		if (!sourcepath.contains(":")) {
			sourcepath = System.getProperty("user.dir") + "\\" + sourcepath;
		}
		if (!destinationpath.contains(":")) {
			destinationpath = System.getProperty("user.dir") + "\\" + destinationpath;
		}

		Path temp = Files.move(Paths.get(sourcepath), Paths.get(destinationpath));// function moves the file from source to destination
	}

	public static void mkdir(String path) { // create new folder
		if (!path.contains(":")) {
			path = System.getProperty("user.dir") + "\\" + path;
		}

		File file = new File(path);
		if (!file.exists()) { //check if folder exists already or not
			if (file.mkdir()) {
				System.out.println("Directory is created!");
			} else {
				System.out.println("Failed to create directory!");
			}
		}
	}

	public static void rmdir(String path) { // delete the empty folders
		if (!path.contains(":")) {
			path = System.getProperty("user.dir") + "\\" + path;
		}

		File folder = new File(path);
		String[] files = folder.list();
		if (files.length == 0) {  // if the folder is empty deleted it
			rm(path);
		} else {
			System.out.println("dir is not empty!!try again!!");

		}

	}

	public static void catt(String path) throws Exception { // print the file content on the console
		if (!path.contains(":")) {
			path = System.getProperty("user.dir") + "\\" + path;
		}

		FileReader fileReader = new FileReader(new File(path));
		String filecontents = "";
		int i;
		while ((i = fileReader.read()) != -1) {
			char ch = (char) i;  // takes char char because if there any space
			filecontents = filecontents + ch;
		}

		System.out.print(filecontents);

	}

	public static void more(String path) throws Exception { // print the file content on the console line by line
		if (!path.contains(":")) {
			path = System.getProperty("user.dir") + "\\" + path;
		}

		FileReader fileReader = new FileReader(new File(path));
		String filecontents = "";
		int i;
		while ((i = fileReader.read()) != -1) {
			char ch = (char) i;
			filecontents = filecontents + ch;
		}

		String s = filecontents;
		String[] ss = s.split(" "); // when it find a space it goes for a new line
		for (String sss : ss) {

			System.out.println(sss);

		}
	}

	public static void echo(String echos) { //prints the argument.
		System.out.println(echos);

	}

	public static void args(String cmd) { // which argument should i take
		if (cmd.equalsIgnoreCase("clear")) {
			System.out.println("clear         no args.");
		} else if (cmd.equalsIgnoreCase("exit")) {
			System.out.println("exit          no args.");
		} else if (cmd.equalsIgnoreCase("help")) {
			System.out.println("help          no args.");
		} else if (cmd.equalsIgnoreCase("cd")) {
			System.out.println("cd            path.");
		} else if (cmd.equalsIgnoreCase("ls")) {
			System.out.println("ls            no args.");
		} else if (cmd.equalsIgnoreCase("pwd")) {
			System.out.println("pwd           no args.");
		} else if (cmd.equalsIgnoreCase("cp")) {
			System.out.println("cp            sourcepath,destination path.");
		} else if (cmd.equalsIgnoreCase("mv")) {
			System.out.println("mv            sourcepath,destination path.");
		} else if (cmd.equalsIgnoreCase("rm")) {
			System.out.println("rm            path.");
		} else if (cmd.equalsIgnoreCase("mkdir")) {
			System.out.println("mkdir         directory path.");
		} else if (cmd.equalsIgnoreCase("rmdir")) {
			System.out.println("rmdir         directory path.");
		} else if (cmd.equalsIgnoreCase("date")) {
			System.out.println("date          no args");
		} else if (cmd.equalsIgnoreCase("echo")) {
			System.out.println("echo          1 arg(string want to print?.");
		} else if (cmd.equalsIgnoreCase("cat")) {
			System.out.println("cat           path.");
		} else if (cmd.equalsIgnoreCase("uname")) {
			System.out.println("uname         no args.");
		} else if (cmd.equalsIgnoreCase("users")) {
			System.out.println("users         no args.");
		} else if (cmd.equalsIgnoreCase("who")) {
			System.out.println("who           no args.");
		} else if (cmd.equalsIgnoreCase("pipeOperator")) {
			System.out.println(
					"pipeOperator  Redirect the output to be written to a file using the redirect > create/replace file operator");
		} else if (cmd.equalsIgnoreCase("RediretOper")) {
			System.out.println(
					"RedirectOper  Redirect the output to be written to a file using the redirect >> create/append to file operator.");
		}
	}

	public static void overridde(String over, String path) throws Exception {
		if (!path.contains(":")) {
			path = System.getProperty("user.dir") + "\\" + path;
		}

		File file = new File(path);
		FileWriter fl = new FileWriter(file, false);
		fl.write(over);
		fl.close();
		System.out.println("file is successfully overwritting!!");

	}

	public static void appendd(String appen, String path) throws Exception {
		if (!path.contains(":")) {
			path = System.getProperty("user.dir") + "\\" + path;
		}
		File file = new File(path);
		FileWriter fl = new FileWriter(file, true);
		fl.write(appen);
		fl.close();
		System.out.println("file is successfully appending!!");

	}

	public static void lss(String path) {
		if (!path.contains(":")) {
			path = System.getProperty("user.dir") + "\\" + path;
		}
		terminal.cd(path);
		terminal.ls();

	}

	public static void exit() {
		System.out.println("thank you for using our terminal... !");
		System.exit(0);
	}

}
