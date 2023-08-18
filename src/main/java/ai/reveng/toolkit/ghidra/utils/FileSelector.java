package ai.reveng.toolkit.ghidra.utils;

import java.io.File;

import javax.swing.JFileChooser;

public class FileSelector {
	public static File askForFile() {
		JFileChooser fileChooser = new JFileChooser();

		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setDialogTitle("Select a File");

		int userSelection = fileChooser.showOpenDialog(null);

		if (userSelection == JFileChooser.APPROVE_OPTION) {
			return fileChooser.getSelectedFile();
		} else {
			return null;
		}
	}
}
