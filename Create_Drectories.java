/*A Java code that will create a directory
 * and sub directories within a Windows PC
 * 
 * Author: James Gilles
 * */
import java.io.File;
import java.time.YearMonth;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Create_Drectories {
	public static void main(String[] args){
		
		//create a Name & attach the date to the Directory
		YearMonth daTe = YearMonth.now();
		String myNewDirectory = "Directory created - " + daTe;
		
		//List of sub-directories to be inserted into the new directory
		String[] subDir = {"DIR 1","DIR 2","DIR 3","DIR 4"};
		
		//Another list of sub-directories to be inserted into DIR 4
		String[] sub_subDir = {"DIR A","DIR B"};
		
		//Destination Path to create the file.
		//Your path will be different on your PC
		String destination = "C:\\Users\\Gilles the Great\\Desktop\\";
		
		//Insert the path & directory name
		File inputDir = new File(destination + myNewDirectory);
		
		//Popup to confirm the directory creation
		if(inputDir.exists()){
			JLabel label = new JLabel(inputDir.getName() + " already exists!", JLabel.CENTER);
			label.setAlignmentX(0);
			label.setAlignmentY(0);
			JFrame frame = new JFrame("Creating Directories");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(400,200);
			frame.setVisible(true);
			frame.add(label);
			System.out.println(inputDir.getName() + " already exists!");
			return;
			}
			
		else{
			//Create & insert the directory and the Popup
			inputDir.mkdir();
			JLabel label = new JLabel(inputDir.getName() + " has been created!", JLabel.CENTER);
			label.setAlignmentX(0);
			label.setAlignmentY(0);
			JFrame frame = new JFrame("Creating Directories");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(400,200);
			frame.setVisible(true);
			frame.add(label);
			System.out.println(inputDir.getName() + " has been created!");
			//Insert the sub-directories
			for(int i = 0; i<= subDir.length-1; ++i){
				File subDirs = new File(inputDir +"\\"+subDir[i]);
				subDirs.mkdir();
				
				//Insert the sub_sub-directories into 1 sub-directory
				if(subDir[i] == "DIR 1"){
					
					for(int j = 0; j <= sub_subDir.length-1; ++j){
						File subSubDir = new File(inputDir + "\\DIR 1\\" + sub_subDir[j]);
						subSubDir.mkdir();
					}
				}
			}
		}
	}
}