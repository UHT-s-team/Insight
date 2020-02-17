# -*- coding: utf-8 -*-
# author：albert time:2020/2/10

from snownlp import sentiment, SnowNLP
import pymysql as pq

def Sql(pingfen):
    connect = pq.connect(host='116.62.159.13', user='root',
                              passwd='81234567', db='mybatis', charset='utf8')
    cursor = connect.cursor()
    sql = 'SELECT * FROM `mybatis`.`gametouser` WHERE `G_ID`=11190 AND `D_START`=%s LIMIT 100;'

    cursor.execute(sql, pingfen)
    result = cursor.fetchall()
    元数据 = []
    for x in result:
        元数据.append(x[7])
    connect.commit()
    cursor.close()
    connect.close()
    return 元数据

元数据 = Sql(4)

bad_all = 0
all = len(元数据)

sentiment.classifier.load('sentiment.marshal')
for e in 元数据:
    snlp = SnowNLP(e)
    # print(snlp.sentiments)
    if snlp.sentiments < 0.5:
        bad_all = bad_all + 1

print("总评论：", all)
print("差评数：", bad_all)
print("差评占比：", bad_all/all*100, "%")