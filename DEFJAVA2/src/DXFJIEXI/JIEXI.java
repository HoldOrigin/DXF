package DXFJIEXI;
import java.io.*;
import java.util.ArrayList;
import DXFJIEXI.ChangeCharset;

public class JIEXI {
	private String FileName;
	//private InputStream bReader=null;
	private BufferedReader bReader;
	private String temp1,temp2,temp3,temp4,temp5,temp6,temp7;
	private ArrayList linelist;
	private ArrayList ellipselist;
	private ArrayList circlelist;
	private ArrayList lwpolylinelist;
	private ArrayList arclist;
	private ArrayList alllist=new ArrayList();
	private int n=0,j=0; 
String readString(BufferedReader datain){
   String temp=null;
	 try {
		temp=new String(datain.readLine());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	ChangeCharset test = new ChangeCharset(); 
	try {
		temp=test.toUTF_8(temp);
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    return temp;
	}

  public JIEXI(String path) {
		FileName = path;
		File f = new File(FileName);
		if (!f.exists()) {
			System.out.println("File Not Exist");
			System.exit(0);
		}
		FileReader fr = null;
		try {
		  fr = new FileReader(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bReader = new BufferedReader(fr);
		System.out.println("Begin read file" + FileName);
		temp1 = readString(bReader);// 从DXF文件中读取一个字符串
		while (!temp1.equals("EOF")) {// 未到文件结束标志
			temp1 = readString(bReader);
			if (temp1.equals("ENTITIES")) { // 实体段开始
				temp2 = readString(bReader);
				while (true) {
					temp2 = readString(bReader);
					// 判断POINT实体结束
					if (temp2.equals("CIRCLE")) {// 判断CIRCLE实体开始
						circlelist=new ArrayList();
						 circlelist.add("1");
						while (true) {
							temp3 = readString(bReader);
							if (temp3.equals(" 10")) {
								temp4 = readString(bReader);
								circlelist.add(temp4);
							}
							if (temp3.equals(" 20")) {
								temp4 = readString(bReader);
								circlelist.add(temp4);
							}
							if (temp3.equals(" 30")) {
								temp4 = readString(bReader);
								circlelist.add(temp4);
							}
							if (temp3.equals(" 40")) {
								temp4 = readString(bReader);
								circlelist.add(temp4);
								break;
							}
						}
					alllist.add(circlelist);
					alllist.add("\n");
					}
					// 判断CIRCLE实体结束
					if (temp2.equals("ELLIPSE")) {// 判断ellipse实体开始
						ellipselist=new ArrayList();
					    ellipselist.add("5");
						while (true) {
							temp3 = readString(bReader);
							if (temp3.equals(" 10")) {
								temp4 = readString(bReader);
								ellipselist.add(temp4);
							}
							if (temp3.equals(" 20")) {
								temp4 = readString(bReader);
								ellipselist.add(temp4);
							}
							if (temp3.equals(" 30")) {
								temp4 = readString(bReader);
								ellipselist.add(temp4);
							}
							if (temp3.equals(" 11")) {
								temp4 = readString(bReader);
								ellipselist.add(temp4);
							}
							if (temp3.equals(" 21")) {
								temp4 = readString(bReader);
								ellipselist.add(temp4);
							}
							if (temp3.equals(" 31")) {
								temp4 = readString(bReader);
								ellipselist.add(temp4);
							}
							if (temp3.equals(" 40")) {
								temp4 = readString(bReader);
								ellipselist.add(temp4);
							}
							if (temp3.equals(" 41")) {
								temp4 = readString(bReader);
								ellipselist.add(temp4);
							}
							if (temp3.equals(" 42")) {
								temp4 = readString(bReader);
								ellipselist.add(temp4);
								break;
							}		
						}
					alllist.add(ellipselist);
					alllist.add("\n");
					}
					// 判断ellipse实体结束
					if (temp2.equals("ARC")) {// 判断ARC实体开始
						arclist=new ArrayList();
					    arclist.add("4");
						while (true) {
							temp3 = readString(bReader);
							if (temp3.equals(" 10")) {                    
								temp4 = readString(bReader);
								arclist.add(temp4);
							}
						
							if (temp3.equals(" 20")) {
								temp4 = readString(bReader);
								arclist.add(temp4);
							}
							if (temp3.equals(" 30")) {
								temp4 = readString(bReader);
								arclist.add(temp4);
							}
							if (temp3.equals(" 40")) {// 半径
								temp4 = readString(bReader);
								arclist.add(temp4);
							}
							if (temp3.equals(" 50")) {// 弧的起始角度
								temp4 = readString(bReader);
								arclist.add(temp4);
							}
							if (temp3.equals(" 51")) {// 弧的终止角度
								temp4 = readString(bReader);
								arclist.add(temp4);
								break;
							}
						}
						alllist.add(arclist);
						alllist.add("\n");
					}
					// 判断ARC实体结束
					if (temp2.equals("LINE")) {// 判断ellipse实体开始
						linelist=new ArrayList();
					    linelist.add("3");
						while (true) {
							temp3 = readString(bReader);
							if (temp3.equals(" 10")) {
								temp4 = readString(bReader);
								linelist.add(temp4);
							}
							if (temp3.equals(" 20")) {
								temp4 = readString(bReader);
								linelist.add(temp4);
							}
							if (temp3.equals(" 30")) {
								temp4 = readString(bReader);
								linelist.add(temp4);
							}
							if (temp3.equals(" 11")) {
								temp4 = readString(bReader);
								linelist.add(temp4);
							}
							if (temp3.equals(" 21")) {
								temp4 = readString(bReader);
								linelist.add(temp4);
							}
							if (temp3.equals(" 31")) {
								temp4 = readString(bReader);
								linelist.add(temp4);
								break;
							}
						}
					alllist.add(linelist);
					alllist.add("\n");
					}
					// 判断LINE实体结束
					if (temp2.equals("LWPOLYLINE")) {
						lwpolylinelist=new ArrayList();
						lwpolylinelist.add("2");
						while (true) {
							temp3 = readString(bReader);
							if (temp3.equals(" 90")){
								temp4= readString(bReader);	
								lwpolylinelist.add(temp4);
							}
							if (temp3.equals(" 10")) {
								temp4= readString(bReader);
								lwpolylinelist.add(temp4);	
							}
							if (temp3.equals(" 20")) {
								temp4= readString(bReader);
								lwpolylinelist.add(temp4);
								temp7 = "0.0";// 有些隐含42没有出现，而默认值是0
								temp5 = readString(bReader);
								if (temp5.equals(" 42")) {
									temp6 = readString(bReader);
									lwpolylinelist.add(temp6);	
									}	
								else if(temp5.equals(" 10")) {
									lwpolylinelist.add(temp7);
									temp4= readString(bReader);
									lwpolylinelist.add(temp4);
									continue;
								}
								else if (temp5.equals("  0")) {
									lwpolylinelist.add(temp7);
									break;
								     }
							}
							if(temp3.equals("  0"))break;	
						}	
						alllist.add(lwpolylinelist);
						alllist.add("\n");
					}
					// 判断LWPOLYLINE实体结束
					if (temp2.equals("ENDSEC"))
						{
						break;}
				} // 实体段结束的循环结束  			
			}	// 实体段结束
		} // 文件循环语句结束
	} // jiexi函数结束
  void displayall(){
	  for(int i=0;i<alllist.size();i++)
	 {
		 System.out.print((alllist.get(i)));
		 } 
    }
	public static void main(String[] args) {
	    JIEXI object1=new JIEXI("d:\\房屋.dxf");
	    object1.displayall();
	}
}

