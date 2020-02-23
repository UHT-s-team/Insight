# -*- coding: utf-8 -*-
# author：albert time:2020/2/17
import pymysql as pq
import sys
from wordcloud import WordCloud, ImageColorGenerator
import matplotlib.pyplot as plt
import platform

def Sql(indate):
    print("正在读取数据库！")
    connect = pq.connect(host='116.62.159.13', user='root',
                              passwd='81234567', db='mybatis', charset='utf8')
    cursor = connect.cursor()
    G_ID = indate[0]
    sql = 'SELECT * FROM `mybatis`.`TFIDF` WHERE `G_ID` LIKE %s ORDER BY `weight` DESC LIMIT 100;'
    cursor.execute(sql, G_ID)
    result = cursor.fetchall()
    元数据 = []
    元数据.append(G_ID)
    for x in result:
        dada = []
        dada.append(x[2])
        dada.append(str(x[3]))
        元数据.append(dada)
    connect.commit()
    cursor.close()
    connect.close()
    return 元数据

yun = 'yun.jpg'
indate = sys.argv[1:]
元数据 = Sql(indate)
words = {}
for x in 元数据[1:]:
    words[str(x[0])] = float(x[1])
print(words)
wc = WordCloud(width=1024, height=720, font_path='simkai.ttf', background_color='white', mask= plt.imread(yun))
wc.generate_from_frequencies(words)
plt.imshow(wc)
plt.axis("off")
#plt.show()

sysstr = platform.system()
if(sysstr =="Windows"):
    wc.to_file("D://学习//代码//JavaWeb//Insight//src//main//resources//static//img//"+indate[0] + '.png')
if(sysstr == "Linux"):
    wc.to_file("/root/Insight/src/main/java/resources/static/img/"+indate[0] + '.png')

