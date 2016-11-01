package JavaBasics;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 
 * @author chenlizi-ext
 *
 * Split One big file to multiple files
 */
public class FileSpliter {

	public static void main(String[] args){
		
		String path = "C:/Users/chenlizi-ext/Downloads/keywordsList.txt";
		
		split(path, 1, "C:/Users/chenlizi-ext/Downloads/");
		
	}
	
	public static void split(String src, int fileSize, String dest){
		
		if("".equals(src)||src==null||fileSize==0||"".equals(dest)||dest==null){
			System.out.println("�ָ�ʧ��");
		}
		
		File srcFile = new File(src);//Դ�ļ�
		
		long srcSize = srcFile.length();//Դ�ļ��Ĵ�С
		long destSize = 128*1024*fileSize;//Ŀ���ļ��Ĵ�С���ָ��ÿ���ļ��Ĵ�С��
		
		int number = (int)(srcSize/destSize);
		number = srcSize%destSize==0?number:number+1;//�ָ���ļ�����Ŀ
		
		String fileName = src.substring(src.lastIndexOf("/"));//Դ�ļ���
		
		InputStream in = null;//�����ֽ���
		BufferedInputStream bis = null;//���뻺����
		byte[] bytes = new byte[1024];//ÿ�ζ�ȡ�ļ��Ĵ�СΪ1MB
		int len = -1;//ÿ�ζ�ȡ�ĳ���ֵ
		try {
			in = new FileInputStream(srcFile);
			bis = new BufferedInputStream(in);
			for(int i=0;i<number;i++){
				
				String destName = dest+File.separator+fileName+"-"+i+".dat";
				OutputStream out = new FileOutputStream(destName);
				BufferedOutputStream bos = new BufferedOutputStream(out);
				int count = 0;
				while((len = bis.read(bytes))!=-1){
					bos.write(bytes, 0, len);//���ֽ�����д��Ŀ���ļ���
					count+=len;
					if(count>=destSize){
						break;
					}
				}
				bos.flush();//ˢ��
				bos.close();
				out.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			//�ر���
			try {
				if(bis!=null)bis.close();
				if(in!=null)in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	}
	
}
