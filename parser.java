package assignment_OS_klaket_tany_mara;

public class parser {
	public boolean parse(String[] input) {
		if (input[0].equalsIgnoreCase("$clear") && input.length == 1) {
			return true;
		}

		else if (input[0].equalsIgnoreCase("$help") && input.length == 1) {
			return true;
		}

		else if (input[0].equalsIgnoreCase("$date") && input.length == 1) {
			return true;
		} else if (input[0].equalsIgnoreCase("$exit") && input.length == 1) {
			return true;
		} else if (input[0].equalsIgnoreCase("$pwd") && input.length == 1) {
			return true;
		} else if (input[0].equalsIgnoreCase("$args") && input.length == 2) {
			return true;
		} else if (input[0].equalsIgnoreCase("$ls") && input.length == 1) {
			return true;
		}

		else if (input[0].equalsIgnoreCase("$exit") && input.length == 1) {
			return true;
		}
//		else if(input[2].equalsIgnoreCase("|") && input.length==4) {
//			return true;
//		}
		else if (input[1].equalsIgnoreCase("|") && input.length == 3) {
			return true;
		} else if (input[0].equalsIgnoreCase("$who") && input.length == 1) {
			return true;
		} else if (input[0].equalsIgnoreCase("$uname") && input.length == 1) {
			return true;
		} else if (input[0].equalsIgnoreCase("$users") && input.length == 1) {
			return true;
		} else if (input[0].equalsIgnoreCase("$cd") && input.length == 2) {
			return true;
		} else if (input[0].equalsIgnoreCase("$cp") && input.length == 3) {
			return true;
		} else if (input[0].equalsIgnoreCase("$rm") && input.length == 2) {
			return true;
		} else if (input[0].equalsIgnoreCase("$mv") && input.length == 3) {
			return true;
		} else if (input[0].equalsIgnoreCase("$mkdir") && input.length == 2) {
			return true;
		} else if (input[0].equalsIgnoreCase("$rmdir") && input.length == 2) {
			return true;
		} else if (input[0].equalsIgnoreCase("$cat") && input.length == 2) {
			return true;
		} else if (input[0].equalsIgnoreCase("$more") && input.length == 2) {
			return true;
		} else if (input[0].equalsIgnoreCase("$echo") && input.length == 2) {
			return true;
		} else if (input[1].equalsIgnoreCase(">") && input.length == 3) {
			return true;
		} else if (input[1].equalsIgnoreCase(">>") && input.length == 3) {
			return true;
		} else {
			return false;
		}

	}

}
