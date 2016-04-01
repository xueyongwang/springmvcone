package cn.ccut.file;
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.OutputStream; 
public class FileCopy {  
    private File inputFile;  
    private File outputFile;  
    private InputStream inputStream;  
    private OutputStream outputStream;  
    public FileCopy(String inputPath,String outputPath) throws FileNotFoundException{  
    	inputFile=new File(inputPath);  
    	outputFile=new File(outputPath);  
    	inputStream=new FileInputStream(inputFile);  
    	outputStream=new FileOutputStream(outputFile);  
          
    }
    /**
     * 边写边复制
     * @throws IOException
     */
    public void copy2() throws IOException{  
    	int temp=0;  
        while((temp=inputStream.read())!=-1){  
            outputStream.write(temp);  
        }  
        inputStream.close();  
        outputStream.close();  
    }  
    public void copy(String in_path,String out_path) throws IOException{
    	//将文件/文件路径转为输入流
    	File inputFile=new File(in_path);
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
    public static void main(String[] args) throws IOException{
    	String inputPath="e:/12.txt";
    	String outputPath="f:34.txt";
        FileCopy fileCopy=new FileCopy(inputPath, outputPath);
        fileCopy.copy2();//测试一下提交
    }  
  
}  
