package assignment_OS_klaket_tany_mara;

import java.util.Scanner;
import java.io.*;

public class main {
	public static void main(String[] args) throws Exception {

		parser p = new parser();
		terminal t = new terminal();

		Scanner sc = new Scanner(System.in);

		String[] cmd = new String[100];

		while (cmd[0] != ("$exit")) {

			System.out.print("Safix@ubuntu: ");

			cmd = sc.nextLine().split(" ");

			if (p.parse(cmd) == true) {

				if (cmd[0].equalsIgnoreCase("$date")) {
					t.date();

				} else if (cmd[0].equalsIgnoreCase("$help")) {
					t.help();

				} else if (cmd[0].equalsIgnoreCase("$clear")) {
					t.clear();

				} else if (cmd[0].equalsIgnoreCase("$pwd")) {
					t.pwd();

				} else if (cmd[0].equalsIgnoreCase("$args")) {
					t.args(cmd[1]);

				}

				else if (cmd[0].equalsIgnoreCase("$ls")) {

					t.ls();

				}

				else if (cmd[0].equalsIgnoreCase("$who")) {
					t.who();

				} else if (cmd[0].equalsIgnoreCase("$uname")) {
					t.uname();

				} else if (cmd[0].equalsIgnoreCase("$users")) {
					t.users();

				} else if (cmd[0].equalsIgnoreCase("$cd")) {

					t.cd(cmd[1]);

				} else if (cmd[0].equalsIgnoreCase("$cp")) {

					t.cp(cmd[1], cmd[2]);

				} else if (cmd[0].equalsIgnoreCase("$rm")) {

					t.rm(cmd[1]);

				} else if (cmd[0].equalsIgnoreCase("$mv")) {

					t.mv(cmd[1], cmd[2]);

				} else if (cmd[0].equalsIgnoreCase("$mkdir")) {

					t.mkdir(cmd[1]);

				} else if (cmd[0].equalsIgnoreCase("$rmdir")) {

					t.rmdir(cmd[1]);

				} else if (cmd[0].equalsIgnoreCase("$cat")) {

					t.catt(cmd[1]);

				} else if (cmd[0].equalsIgnoreCase("$more")) {

					t.more(cmd[1]);

				} else if (cmd[0].equalsIgnoreCase("$exit")) {

					t.exit();

				} else if (cmd[0].equalsIgnoreCase("$echo")) {

					t.echo(cmd[1]);

				}

				else if (cmd[2].equalsIgnoreCase("|") && cmd[0].equalsIgnoreCase("cd")
						&& cmd[3].equalsIgnoreCase("ls")) {

					t.cd(cmd[1]);
					t.ls();

				} else if (cmd[2].equalsIgnoreCase("|") && cmd[0].equalsIgnoreCase("cd")
						&& cmd[3].equalsIgnoreCase("pwd")) {

					t.cd(cmd[1]);
					t.pwd();

				} else if (cmd[1].equalsIgnoreCase("|") && cmd[0].equalsIgnoreCase("ls")
						&& cmd[2].equalsIgnoreCase("more")) {

					t.lsmore();

				} else if (cmd[1].equalsIgnoreCase(">")) {

					t.overridde(cmd[0], cmd[2]);

				} else if (cmd[1].equalsIgnoreCase(">>")) {

					t.appendd(cmd[0], cmd[2]);

				}
			} else if (p.parse(cmd) == false) {
				System.out.println("Wrong....try again");
			}

		}

	}

}
