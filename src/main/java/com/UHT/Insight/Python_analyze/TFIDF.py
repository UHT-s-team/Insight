# -*- coding: utf-8 -*-
# author：albert time:2020/1/25
import pymysql as pq
import re
import jieba
from sklearn import feature_extraction
from sklearn.feature_extraction.text import TfidfTransformer
from sklearn.feature_extraction.text import CountVectorizer
import sys

def Sql(indate):
    connect = pq.connect(host='116.62.159.13', user='root',
                              passwd='81234567', db='mybatis', charset='utf8')
    cursor = connect.cursor()
    G_ID = indate[0]
    indate = " ".join(indate)
    sql = 'SELECT * FROM `gametouser` WHERE `G_ID` LIKE'
    sql = sql + ' ' + indate + ';'
    cursor.execute(sql)
    result = cursor.fetchall()
    元数据 = []
    元数据.append(G_ID)
    for x in result:
        数据 = []
        数据.append(x[1])
        数据.append(x[7])
        元数据.append(数据)

    connect.commit()
    cursor.close()
    connect.close()
    return 元数据

def Sql3(wordss):
    connect = pq.connect(host='116.62.159.13', user='root',
                         passwd='81234567', db='mybatis', charset='utf8')
    cursor = connect.cursor()
    Rsql = "insert into TFIDF(G_ID, word, weight) values(%s, %s, %s);"
    ID = wordss[0]
    wordss = wordss[1:]
    for u in range(len(wordss)):
        # print(str(ID), str(wordss[u][0]), str(wordss[u][1]))
        cursor.execute(Rsql, (str(ID), str(wordss[u][0]), str(wordss[u][1])))
        connect.commit()
    cursor.close()
    connect.close()

def cut_words(元数据):
    切数据 = []
    数据 = ''
    for x in 元数据:
        seg_list = jieba.cut(x[1], cut_all=False)
        # for s in seg_list:
        # print(seg_list)
        stopwords = stop_words('停词(原).txt')
        for word in seg_list:
            if word not in stopwords:
                # print(word)
                value = re.compile(r'^[\u4e00-\u9fa5]{2,}')
                # 数据.append(word)
                if value.match(word):
                    数据 += word + ' '
        #         # print(数据)
        # # print(数据)
        # #             数据.append(outstr)
        # # 数据.append(x[0])
    切数据.append(数据)
    print(切数据)
    return 切数据


def stop_words(stop_word_file):
    with open(stop_word_file, 'r', encoding='UTF-8') as fp:
        words = fp.read()
        stopwords = words.split('\n')
        # print(result)
        return stopwords


def countIdf(切数据, G_ID):
    vectorizer = CountVectorizer()
    transformer = TfidfTransformer()
    tfidf = transformer.fit_transform(vectorizer.fit_transform(切数据))
    weight = tfidf.toarray()
    word = vectorizer.get_feature_names()
    wordss = []
    wordss.append(G_ID)
    for w1, w2 in zip(word, weight[0]):
        # print("word:", w1, w2)
        # print("weight:", w2)
        dd = []
        dd.append(w1)
        dd.append(w2)
        wordss.append(dd)
    Sql3(wordss)


indate = sys.argv[1:]
元数据 = Sql(indate)
G_ID = 元数据[0]
切数据 = cut_words(元数据[1:])
# print(切数据[0:])
weight = countIdf(切数据, G_ID)
# # print(切数据)
# print(weight)
# cut_words(Sql())