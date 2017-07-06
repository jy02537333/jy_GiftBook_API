package com.zxw.util;


/**
 * 带等于符号的json格式，没有引号
 * Created by Administrator on 2017/7/4.
 */
public class JsonEqualSymbolConvertJson {
    public static String handlerjson(String str)
    {
        StringBuffer sb=new StringBuffer();
        String comma=str.trim().substring(0,1);
        if(comma.equals("["))
        {
            String[] arrays=str.trim().substring(1).split("}");
            for (int i = 0; i <arrays.length ; i++) {
                String itemStr=null;
                if(i>0)
                {
                    itemStr=arrays[i].substring(1);
                }else
                    itemStr=arrays[i];
                if(i+1<arrays.length)
                {
                    sb.append( handlerjson(itemStr+"}") ).append(",");
                }else
                {
                    sb.append( handlerjson(itemStr+"}") );
                }

            }
            sb.insert(0,"[");
            sb.append("]");
            return sb.toString();
        }else
        {
            StringBuffer jsonSB=new StringBuffer();
            StringBuffer oldSb=new StringBuffer(str.substring(1,str.length()-1)  );
            sb.append( getJson(oldSb,jsonSB) );
            sb.insert(0,"{");
            sb.append("}");
            return sb.toString();
        }

    }

    public static String getJson(StringBuffer oldSb,StringBuffer jsonSb)
    {

        boolean isObj=false;
        int elIndex=oldSb.indexOf("=");
        int commaIndex=oldSb.indexOf(",");
        String ss=oldSb.substring(0,elIndex);
        String val=null;
        val=oldSb.substring(elIndex+1).trim();
        if(val.trim().length()==0)
            val="null";
        String bracketStr=val.substring(0,1);
        if(bracketStr.equals("[")||bracketStr.equals("{"))
        {
            isObj=true;
            if(val.indexOf("[")>-1)
            {
                commaIndex=oldSb.indexOf("]")+1;
                val=val.substring(0,val.indexOf("]"));
            }
            else if(val.indexOf("{")>-1)
            {
                commaIndex=oldSb.indexOf("}");
                val=val.substring(0,val.indexOf("}"));
            }
            val=handlerjson(val);
        }
        else if(commaIndex==0)
        {
            val="";
        }
        else if(commaIndex==-1)
        {
            val=oldSb.substring(elIndex+1);
        }else{
            val=oldSb.substring(elIndex+1,commaIndex);
        }

        String newStr=oldSb.substring(commaIndex+1);
        ss=ss.trim();
        if(isObj){
            jsonSb.append("\""+ss+"\":"+val);
        }else
        if(val.equals("null"))
            jsonSb.append("\""+ss+"\":null");
        else if(val.toLowerCase().equals("true")||val.toLowerCase().equals("false"))
            jsonSb.append("\""+ss+"\":"+val);
        else
            jsonSb.append("\""+ss+"\":\""+val+"\"");
        if(commaIndex>-1)
        {
            jsonSb.append(",");
        }
        if(newStr.indexOf("=")>0&&commaIndex!=-1)
        {
            oldSb=new StringBuffer(newStr);
            return 	getJson(oldSb,jsonSb);
        }
        return jsonSb.toString();
    }
}
