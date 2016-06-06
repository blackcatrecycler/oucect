# -*- coding: utf-8 -*-
# encoding:utf-8
import urllib2,re
import urllib
import MySQLdb as db

def Search_e(eara,house,room):
    #post的目标地址
    url='http://hqsz.ouc.edu.cn/houqin/store/findone.action'
    #设置post的数据
    boundary='---------------------------12174501422663' #分隔符
    data = []
    data.append('--'+boundary)
    data.append('Content-Disposition: form-data; name="kindId"')
    data.append('')
    data.append('9' )
    data.append('--'+boundary)
    data.append('Content-Disposition: form-data; name="search.text0"')
    data.append('')
    #data.append(eara)
    #查询房间所在区域
    data.append('北区')
    data.append('--'+boundary)
    data.append('Content-Disposition: form-data; name="search.text1"')
    data.append('')
    #查询房间所在的楼号
    data.append(house)
    data.append('--'+boundary)
    data.append('Content-Disposition: form-data; name="search.text2"')
    data.append('')
    #查询房间的房间号
    data.append(room)
    data.append('--'+boundary)
    data.append('Content-Disposition: form-data; name="search.text3"')
    data.append('')
    data.append('')
    data.append('--'+boundary)
    data.append('Content-Disposition: form-data; name="search.text4"')
    data.append('')
    data.append('')
    data.append('--'+boundary)
    data.append('Content-Disposition: form-data; name="search.text5"')
    data.append('')
    data.append('')
    data.append('--'+boundary+'--')
    data.append('')
    httpbody='\r\n'.join(data)
    #以上部分就是查询信息的表单
    content_type='multipart/form-data; boundary=%s' %boundary
    #print data    #检验表单数据
    req = urllib2.Request(url,httpbody)
    req.add_header("Content-Type", content_type )
    req.add_header("Accept-Language","zh-CN,en-US;q=0.7,en;q=0.3")
    req.add_header("Accept-Encoding","gzip, deflate")
    #req.add_header("Connection","keep_alive")
    response = urllib2.urlopen(req)
    html = response.read()
    unicodePage=html.decode("utf-8")
    pattern=ur"<strong>([\s\S]*?)<\/strong>"
    result=re.findall(pattern,unicodePage,re.S)
    try:
        return result[11]
    except:
        return '20.0'

connection = db.connect(host='localhost',user='root',passwd='root',db='oucect',port=3306,init_command='set names utf8')
cursor = connection.cursor()
cursor.execute("select * from rooms");
result = cursor.fetchall()
cursor.close()
connection.close()
print result
for item in result:
    aera=item[3]
    house = item[1]
    room = item[2]
    num=Search_e(aera,house,room)
    connection = db.connect(host='localhost',user='root',passwd='root',db='oucect',port=3306,init_command='set names utf8')
    cursor = connection.cursor()
    cursor.execute("update rooms set ect = "+num+" where id="+str(item[0]));
    connection.commit();
    cursor.close();
    connection.close();
    

