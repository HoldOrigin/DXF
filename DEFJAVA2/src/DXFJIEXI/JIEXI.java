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
		temp1 = readString(bReader);// ��DXF�ļ��ж�ȡһ���ַ���
		while (!temp1.equals("EOF")) {// δ���ļ�������־
			temp1 = readString(bReader);
			if (temp1.equals("ENTITIES")) { // ʵ��ο�ʼ
				temp2 = readString(bReader);
				while (true) {
					temp2 = readString(bReader);
					// �ж�POINTʵ�����
					if (temp2.equals("CIRCLE")) {// �ж�CIRCLEʵ�忪ʼ
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
					// �ж�CIRCLEʵ�����
					if (temp2.equals("ELLIPSE")) {// �ж�ellipseʵ�忪ʼ
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
					// �ж�ellipseʵ�����
					if (temp2.equals("ARC")) {// �ж�ARCʵ�忪ʼ
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
							if (temp3.equals(" 40")) {// �뾶
								temp4 = readString(bReader);
								arclist.add(temp4);
							}
							if (temp3.equals(" 50")) {// ������ʼ�Ƕ�
								temp4 = readString(bReader);
								arclist.add(temp4);
							}
							if (temp3.equals(" 51")) {// ������ֹ�Ƕ�
								temp4 = readString(bReader);
								arclist.add(temp4);
								break;
							}
						}
						alllist.add(arclist);
						alllist.add("\n");
					}
					// �ж�ARCʵ�����
					if (temp2.equals("LINE")) {// �ж�ellipseʵ�忪ʼ
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
					// �ж�LINEʵ�����
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
								temp7 = "0.0";// ��Щ����42û�г��֣���Ĭ��ֵ��0
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
					// �ж�LWPOLYLINEʵ�����
					if (temp2.equals("ENDSEC"))
						{
						break;}
				} // ʵ��ν�����ѭ������  			
			}	// ʵ��ν���
		} // �ļ�ѭ��������
	} // jiexi��������
  void displayall(){
	  for(int i=0;i<alllist.size();i++)
	 {
		 System.out.print((alllist.get(i)));
		 } 
    }
	public static void main(String[] args) {
	    JIEXI object1=new JIEXI("d:\\����.dxf");
	    object1.displayall();
	}
}

