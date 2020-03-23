# -*- coding: utf-8 -*-
# author：albert time:2020/1/25
import pymysql as pq
import re
import jieba
from sklearn import feature_extraction
from sklearn.feature_extraction.text import TfidfTransformer
from sklearn.feature_extraction.text import CountVectorizer
from sklearn.cluster import KMeans
from sklearn.manifold import TSNE
import matplotlib.pyplot as plt
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
    metadata = []
    metadata.append(G_ID)
    for x in result:
        data = []
        data.append(x[1])
        data.append(x[7])
        metadata.append(data)

    connect.commit()
    cursor.close()
    connect.close()
    return metadata

def Sql2(cunshuju, x, y):
    connect = pq.connect(host='116.62.159.13', user='root',
                         passwd='81234567', db='mybatis', charset='utf8')
    cursor = connect.cursor()
    Rsql = "insert into kmean(G_ID,cindex,label,px,py) values(%s, %s, %s, %s, %s);"
    G_ID = cunshuju[0]
    cunshuju = cunshuju[1:]
    # print(cunshuju,x,y)
    for u in range(len(cunshuju)):
        # print(cunshuju[u][0])
        # print(cunshuju[u][1])
        # print(cunshuju[u][2])
        # print(x[u])
        # print(y[u])
        cursor.execute(Rsql, (G_ID, str(cunshuju[u][1]), int(cunshuju[u][2]), str(x[u]), str(y[u])))
        connect.commit()

    cursor.close()
    connect.close()

def cut_words(metadata):
    cutData = []
    data = ''
    for x in metadata:
        seg_list = jieba.cut(x[1], cut_all=False)
        # for s in seg_list:
        # print(seg_list)
        stopwords = stop_words('停词(原).txt')
        for word in seg_list:
            if word not in stopwords:
                # print(word)
                value = re.compile(r'^[\u4e00-\u9fa5]{2,}')
                # data.append(word)
                if value.match(word):
                    data += word + ' '
        #         # print(data)
        # # print(data)
        # #             data.append(outstr)
        # # data.append(x[0])
    cutData.append(data)
    print(cutData)
    return cutData


def stop_words(stop_word_file):
    with open(stop_word_file, 'r', encoding='UTF-8') as fp:
        words = fp.read()
        stopwords = words.split('\n')
        # print(result)
        return stopwords


def countIdf(cutData, G_ID):
    vectorizer = CountVectorizer()
    transformer = TfidfTransformer()
    tfidf = transformer.fit_transform(vectorizer.fit_transform(cutData))
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

    kmeans = KMeans(n_clusters=7)
    test = kmeans.fit(weight.reshape(-1, 1))
    # print(test)
    #
    # # 打印出各个族的中心点
    # print(kmeans.cluster_centers_)
    # print(kmeans.labels_)
    cunshuju = []
    cunshuju.append(G_ID)
    for index, label in enumerate(kmeans.labels_, 1):
        ko = []
        print("word:", word[index-1])
        print("index: {}, label: {}".format(index, label))
        ko.append(index)
        ko.append(word[index - 1])
        ko.append(label)
        cunshuju.append(ko)

    print("inertia: {}".format(kmeans.inertia_))
    tsne = TSNE(n_components=2)
    decomposition_data = tsne.fit_transform(weight.reshape(-1, 1))

    x = []
    y = []
    # print(len(decomposition_data))
    for i in decomposition_data:
        x.append(i[0])
        y.append(i[1])

    fig = plt.figure(figsize=(10, 10))
    ax = plt.axes()
    plt.scatter(x, y, c=kmeans.labels_, marker="x")
    plt.xticks(())
    plt.yticks(())
    # plt.show()

    plt.savefig(G_ID + '.png', aspect=1)

    Sql2(cunshuju, x, y)

indate = sys.argv[1:]
metadata = Sql(indate)
G_ID = metadata[0]
cutData = cut_words(metadata[1:])
# print(cutData[0:])
weight = countIdf(cutData, G_ID)
# # print(cutData)
# print(weight)
# cut_words(Sql())