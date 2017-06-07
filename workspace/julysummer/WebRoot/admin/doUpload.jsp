<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.io.*" %>
<%@ page import="javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% 
	//request.setCharacterEncoding("UTF-8");
	int MAX_SIZE=102400*102400;
			String rootPath;
			DataInputStream in=null;
			FileOutputStream fileOut=null;
			String remoteAddr=request.getRemoteAddr();
			String serveName=request.getServerName();
			String realPath=request.getRealPath("/");
			realPath=realPath.substring(0,realPath.lastIndexOf("\\"));
			rootPath=realPath+"\\upload\\";
			//out.println("the root path is"+rooPath);
			String contentType=request.getContentType();
			try{
				if(contentType.indexOf("multipart/form-data")>=0){
					in=new DataInputStream(request.getInputStream());
					int formDataLength=request.getContentLength();
					if(formDataLength>MAX_SIZE){
						//out.printlbn("be smaller than"+MAX_SIZE);
						return;
					}
					byte dataBytes[]=new byte[formDataLength];
					int byteRead=0;
					int totalBytesRead=0;
					while(totalBytesRead<formDataLength){
						byteRead=in.read(dataBytes,totalBytesRead,formDataLength);
						totalBytesRead+=byteRead;
					}
					String file=new String(dataBytes);
					String saveFile=file.substring(file.indexOf("filename=\"")+10);
					saveFile=saveFile.substring(0,saveFile.indexOf("\n"));
					saveFile=saveFile.substring(saveFile.lastIndexOf("\\")+1,saveFile.indexOf("\""));
					int lastIndex=contentType.lastIndexOf("=");
					
					String boundary=contentType.substring(lastIndex+1,contentType.length());
					String fileName=rootPath+saveFile;
					int pos;
					pos=file.indexOf("filename=\"");
					pos=file.indexOf("\n",pos)+1;
					pos=file.indexOf("\n",pos)+1;
					pos=file.indexOf("\n",pos)+1;
					int boundaryLocation=file.indexOf(boundary,pos)-4;
					int startPos=((file.substring(0,pos)).getBytes()).length;
					int endPos=((file.substring(0,boundaryLocation)).getBytes()).length;
					File checkFile=new File(fileName);
					if(checkFile.exists()){
						//out.print(saveFile+"file exist");
					}
					File fileDir=new File(rootPath);
					if(!fileDir.exists()){
						fileDir.mkdirs();
					}
					fileOut=new FileOutputStream(fileName);
					fileOut.write(dataBytes,startPos,(endPos-startPos));
					fileOut.close();
					//out.print(saveFile+"upload success");
				}else{
					String content=request.getContentType();
					//out.print("the file data is not multipart/form-data");
				}
			}catch(Exception e){throw new ServletException(e.getMessage());}
%>