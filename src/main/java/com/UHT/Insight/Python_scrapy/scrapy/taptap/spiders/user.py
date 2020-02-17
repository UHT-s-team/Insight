# -*- coding: utf-8 -*-
import scrapy
from taptap.items import UserItem

class TapSpider(scrapy.Spider):
    name = 'user'
    allowed_domains = ['taptap.com']
    url = 'https://www.taptap.com/user/'
    游戏编号 = 0
    # 用户ID = 13674013
    # start_urls = [url + str(游戏编号) + '/review?score=' + str(评分) + '&order=update&page=' + str(页码) + '#review-list']
    # start_urls = ['https://www.taptap.com/user/'+str(用户ID)]
    custom_settings = {'ITEM_PIPELINES': {'taptap.pipelines.TapusrPipeline': 300}}
    # print(start_urls)
    def __init__(self, gameNub=None, *args, **kwargs):
        super(TapSpider, self).__init__(*args, **kwargs)
        self.游戏编号 = gameNub

    def start_requests(self):
        cookies = "_ga=GA1.2.779483002.1563987256; tapadid=e363328e-e5d0-d464-98cf-0c6ea36f0805; bottom_banner_hidden=1; user_id=55689839; remember_web_59ba36addc2b2f9401580f014c7f58ea4e30989d=eyJpdiI6IkVBd3FiREVRRlwvNFdRNUtFVVcxenVnPT0iLCJ2YWx1ZSI6Ikp3UEZ2SVZWRFBLYnpROEt3TjdjSndhSWtjZGk4U1BSTGoxY0RCTWF3ZnFHakFVeGUwSU5SRG1pTmNBYm50bDJMWVV1M0lVakcyWVBzSVRxRzdubXltWUNkYmExT1M3S05Tdmg3V2FkTVVVPSIsIm1hYyI6IjVmZjQwYjYxOWFlODgyZDlhYTEwODJmZjIyY2M5NjE5OTE0NWY0ODVlNDY5YzVkZGYyMzNmNjNkOTg3NTY3NTYifQ%3D%3D; acw_tc=b65cfd3b15736480452344305e442e8b305e10ebc4a04b819bcaa76be772cd; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%2255689839%22%2C%22%24device_id%22%3A%2216c24e7a2ef123-0686956d5546b7-c343162-2073600-16c24e7a2f0aba%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_referrer%22%3A%22%22%2C%22%24latest_referrer_host%22%3A%22%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%7D%2C%22first_id%22%3A%2216c24e7a2ef123-0686956d5546b7-c343162-2073600-16c24e7a2f0aba%22%7D; region=CN; _gid=GA1.2.1359996011.1575697299; acw_sc__v1=5deb5958999653f66e4295fd229685d6aa0d4dcd; _gat=1; XSRF-TOKEN=eyJpdiI6IlZ1SU5FOTJOT1BJd0Z5VXhldzhhREE9PSIsInZhbHVlIjoiNzRZbFlIQ1dcL0pqemM0V2lXUmc2VTlndGx4Q1ZVbXN0M1NraGdwS2p3ZXR5NjlkMTdzXC9HMDZWc1RtSXVXbERqNmlOZUNlVG5uZnZhRUo2ZE0rQW4zQT09IiwibWFjIjoiNmJhYTI1ZDhlODYyYTc4YWNjMjlhNGI2Y2UwOTNmOWZmYWEwN2YyNDdjNzg0ZGI4MmRhMTUxMjhkMjc2MTg1MiJ9; tap_sess=eyJpdiI6IkNKbVZ0VW52ZGxRXC9tRVlxYmFpVjhRPT0iLCJ2YWx1ZSI6IjQ1R3ZzRTI2VVk1anZhbHlnZjJEK001Wk44bElIMnljTTJsRDBxOVQ5MmtBMldvREpwbGljVEpVODRKaXVjZndSeVpqR0pHbml4NUYzejZ4SnNEN1NnPT0iLCJtYWMiOiI3ZjhiZDYwMGE5MGI0NTU5ZjVhMmYxYTU3ODdkODE1NDIyZTc3OWI1YWY3MWQwMWJlMjY4NTU3Y2FjNDBhNzNlIn0%3D"
        cookies = {i.split("=")[0]:i.split("=")[1] for i in cookies.split("; ")}
        # file = [13674013]

        user_url = 'https://www.taptap.com/user/' + str(self.游戏编号)
        # print('no3', user_url)
        # yield scrapy.Request(user_url, callback=self.parse)
        yield scrapy.Request(user_url, callback=self.parse, cookies=cookies)

        # user_url = 'https://www.taptap.com/user/' + str(x)
        # yield scrapy.Request(user_url, callback=self.parse, cookies=cookies)

        # with open('C:/py3/test/' + str(self.游戏编号) + '.json', 'r', encoding='utf-8') as js:
        #     file = json.load(js)
        #     for y in file:
        #         try:
        #             x = y['用户ID'][0]
        #             user_url = 'https://www.taptap.com/user/' + str(x)
        #             yield scrapy.Request(user_url, callback=self.parse, cookies=cookies)
        #
        #         except:
        #             print('null')
        #     js.close()
        #
        # for x in file:
        #     user_url = 'https://www.taptap.com/user/' + str(x)
        #     print('no3', user_url)
        #     # yield scrapy.Request(user_url, callback=self.parse)
        #     yield scrapy.Request(user_url, callback=self.parse, cookies=cookies)

    def parse(self, response):
        user2 = response.xpath('//body')
        # print('url',response.url)
        game_url = str(response.url)+'?page=1'
        user3 = response.xpath('//*[@id="played"]/section/ul/li')
        user_list = []
        # print(user_list1)
        for user in user2:
            item = UserItem()
            用户id集= []
            用户id = user.xpath(".//div[@class='user-all-info']/span[1]/text()").extract()
            for i in 用户id:
                用户 = [i.strip("ID:")]
                用户id集.append(用户[0])
            用户名 = user.xpath(".//div[@class='user-all-info']/h1/text()").extract()
            if len(user.xpath("./div[1]/div[1]/div/section/div[1]/div/p[1]/text()").extract()):
                签名 = user.xpath("./div[1]/div[1]/div/section/div[1]/div/p[1]/text()").extract()
            else:
                签名='Null'
            if len(user.xpath(".//p[@class='left-text-vote']/span[1]/text()").extract()):
                收到的赞 = user.xpath(".//p[@class='left-text-vote']/span[1]/text()").extract()
            else:
                收到的赞 = "0"
            if len(user.xpath(".//p[@class='left-text-vote']/span[2]/text()").extract()):
                收到的欢乐 = user.xpath(".//p[@class='left-text-vote']/span[2]/text()").extract()
            else:
                收到的欢乐 = "0"
            if len(user.xpath("./div[1]/div[1]/div/section/div[2]/ul/li[1]/a/span[1]/text()").extract()):
                粉丝数 = user.xpath("./div[1]/div[1]/div/section/div[2]/ul/li[1]/a/span[1]/text()").extract()
            else:
                粉丝数 = "0"
            if len(user.xpath("./div[1]/div[1]/div/section/div[2]/ul/li[2]/a/span[1]/text()").extract()):
                关注数 = user.xpath("./div[1]/div[1]/div/section/div[2]/ul/li[2]/a/span[1]/text()").extract()
            else:
                关注数 = "0"
            if len(user.xpath("./div[1]/div[1]/div/section/div[2]/ul/li[3]/a/span[1]/text()").extract()):
                收藏数 = user.xpath("./div[1]/div[1]/div/section/div[2]/ul/li[3]/a/span[1]/text()").extract()
            else:
                收藏数 = "0"
            if len(user.xpath(".//*[@id='played-tab']/span/text()").extract()):
                玩过游戏数 = user.xpath(".//*[@id='played-tab']/span/text()").extract()
            else:
                玩过游戏数 = "0"
            if len(user.xpath(".//*[@id='reviews-tab']/span/text()").extract()):
                评价数 = user.xpath(".//*[@id='reviews-tab']/span/text()").extract()
            else:
                评价数 = "0"
            if len(user.xpath(".//*[@id='topics-tab']/span/text()").extract()):
                帖子数 = user.xpath(".//*[@id='topics-tab']/span/text()").extract()
            else:
                帖子数 = "0"
            if len(user.xpath(".//*[@id='posts-tab']/span/text()").extract()):
                回复数 = user.xpath(".//*[@id='posts-tab']/span/text()").extract()
            else:
                回复数 = "0"
            item['用户名'] =用户名
            item['用户ID'] =用户id集
            item['签名'] =签名
            item['收到的赞'] =收到的赞
            item['收到的欢乐'] =收到的欢乐
            item['粉丝数'] =粉丝数
            item['关注数'] =关注数
            item['收藏数'] =收藏数
            item['玩过游戏数'] =玩过游戏数
            item['评价数'] =评价数
            item['帖子数'] =帖子数
            item['回复数'] =回复数
            # yield item

        if user3:
            yield scrapy.Request(game_url, callback=self.parse_next, meta={"item": item, "user_list": user_list})

    def parse_next(self, response):

        reviews_page = response.xpath('//*[@id="reviews-tab"]').extract()
        item = response.meta["item"]
        user_list = response.meta["user_list"]
        user3 = response.xpath('//*[@id="played"]/section/ul/li')
        next_play_game = response.xpath("//*[@id='played']/section/div[2]/section/ul/li[last()]/a/@href").extract()
        for user1 in user3:
            user_D={}
            玩过的游戏集 = []
            玩过的游戏I = []
            玩过的游戏ID = user1.xpath("./@id").extract()
            玩过的游戏 = user1.xpath("./div/h2//text()").extract()
            玩过的游戏评分 = user1.xpath("./div/span[1]/text()").extract()
            玩过的游戏类型 = user1.xpath("./div/p/span/text()").extract()
            if len(user1.xpath("./div/span[2]/text()").extract()):
                玩过的游戏时长 = user1.xpath("./div/span[2]/text()").extract()
            else:
                玩过的游戏时长 = "0"
            # 玩过的游戏时长 = user1.xpath("./section/ul/li/div/span[2]/text()").extract()
            for i in 玩过的游戏:
                玩过的游戏 = [i.strip("\n ")]
                玩过的游戏集.append(玩过的游戏[0])
            for p in 玩过的游戏ID:
                玩过的游戏ID = [p.strip("played-")]
                玩过的游戏I.append(玩过的游戏ID[0])

            玩过的游戏集 = [x for x in 玩过的游戏集 if x != '']
            # print("玩过的游戏" + str(玩过的游戏集))
            # print("玩过的游戏评分" + str(玩过的游戏评分))
            # print("玩过的游戏时长" + str(玩过的游戏时长))
            # print("玩过的游戏类型" + str(玩过的游戏类型))
            # item['玩过的游戏'] =玩过的游戏集
            # item['玩过的游戏评分'] =玩过的游戏评分
            # item['玩过的游戏类型'] =玩过的游戏类型
            # item['玩过的游戏时长'] =玩过的游戏时长
            user_D['游戏名称'] =玩过的游戏集
            user_D['游戏评分'] =玩过的游戏评分
            user_D['游戏类型'] =玩过的游戏类型
            user_D['游戏时长'] =玩过的游戏时长
            user_D['玩过的游戏ID'] = 玩过的游戏I
            user_list.append(user_D)
            # print(user_list)

            # yield item
        # print('user_list',user_list)
        if next_play_game:
            next_page = next_play_game[0]
            yield scrapy.Request(next_page, callback=self.parse_next, meta={"item": item, "user_list": user_list})
        else:
            item['玩过的游戏'] = user_list
            yield item
            # print('user_list', user_list)
        # elif reviews_page:
        #     reviews_url = self.url + str(self.用户ID)+"/reviews"
        #     yield scrapy.Request(reviews_url, callback=self.pare_reviews)


    # def pare_reviews(self, response):
    #
    #     reviews_list = response.xpath("//*[@id='reviews']/section/ul/li")
    #     next_reviews = response.xpath("//*[@id='reviews']/section/div[2]/section/ul/li[4]/a/@href").extract()
    #     for reviews in reviews_list:
    #         usr_item = UserItem()
    #         游戏名 = reviews.xpath("./div/a/h2/text()").extract()
    #         if len(reviews.xpath("./div/p/span/text()").extract()):
    #             游戏时长 = reviews.xpath("./div/p/span/text()").extract()
    #         else:
    #             游戏时长 = "0"
    #         评分长度 = reviews.xpath("./div/span/@style").extract()
    #         评论时间 = reviews.xpath("./div/p/a/span/text()[1]").extract()
    #         评论 = reviews.xpath("./div/div/a/p/text()").extract()
    #         评分长度 = [评分长度[0].strip("width: ")]
    #         评分长度 = [评分长度[0].strip("px")]
    #         print(评分长度[0])
    #         评分长度 = int(评分长度[0])/14
    #         if 评分长度 == 1:
    #             评分 = 1
    #         elif 评分长度 == 2:
    #             评分 = 2
    #         elif 评分长度 == 3:
    #             评分 = 3
    #         elif 评分长度 == 4:
    #             评分 = 4
    #         elif 评分长度 == 5:
    #             评分 = 5
    #         print(游戏名)
    #         print(游戏时长)
    #         print(评分)
    #         print(评论时间)
    #         print(评论)
    #         if next_reviews:
    #             next_page = next_reviews[0]
    #             yield scrapy.Request(next_page, callback=self.pare_reviews)
    #         yield usr_item
    # #
    #
