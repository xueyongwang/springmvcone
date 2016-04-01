package cn.ccut.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
	
	public static void main(String args[]) throws IOException{
		dealFile("C:/Users/Administrator/Desktop/g/me","C:/Users/Administrator/Desktop/g/br","C:/Users/Administrator/Desktop/g/se/");
	}
	/**
	 * 入口
	 * @param our_filename_path	这个路径是老师自己的学生的路径，也就是老师要生成最终的文件名称来源的文件路径
	 * @param others_file_path	这个路径是其他人的文件的路径，也就是老师用他们的文件换成自己学生的名字形成的最终文件
	 * @param out_path			这个路径是最终系统生成的路径 注意路径后加/
	 * @throws IOException
	 */
	public static void dealFile(String our_filename_path,String others_file_path,String out_path) throws IOException{
		//将自己学生的名字形成输出流的路径
		List<String> tar_name = getFileName(our_filename_path,out_path);
		//获取他人的文件，用作形成自己的文件
		File[] tempList = new File(others_file_path).listFiles();
		int k = 0;
		for (int i = 0; i < tempList.length; i++) {
			if (tempList[i].isFile()) {//如果当前是一个文件
				//自己的文件名改成别人文件名
				copy(tempList[i], tar_name.get(k));
				k++;
			}
		}
	}
	
	/**
	 * 获取输出文件path
	 * @param path	自己学生的文件名称的路径
	 * @param out_path	输出路径
	 * @return
	 */
	public static List<String> getFileName(String path,String out_path){
		List<String> tar_name = new ArrayList<String>();
		File file=new File(path);
		File[] tempList = file.listFiles();
		System.out.println(path+"目录下文件个数："+tempList.length);
		for (int i = 0; i < tempList.length; i++) {
			if (tempList[i].isFile()) {
				System.out.println("文件名称："+tempList[i].getName());
				tar_name.add(out_path+tempList[i].getName());
			}
		}
		return tar_name;
	}
	/**
	 * 文件的复制
	 * @param inputFile
	 * @param out_path
	 * @throws IOException
	 */
	public static void copy(File inputFile,String out_path) throws IOException{
    	//将文件/文件路径转为输入流
    	//File inputFile=new File(in_path);
    	InputStream inputStream=new FileInputStream(inputFile);
    	//获取输出流
    	File outputFile=new File(out_path);
    	OutputStream outputStream=new FileOutputStream(outputFile);
    	int temp=0;
    	while((temp=inputStream.read())!=-1){
    		outputStream.write(temp);
    	}
    	inputStream.close();
    	outputStream.close();
    } 
}
