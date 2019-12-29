from scrapy import cmdline

cmdline.execute("scrapy crawl tap -a gameNub=147488 -s LOG_FILE=147488.log".split())

# cmdline.execute("scrapy crawl 名称                   -s LOG_FILE=xx.log".split())

#或者
#cmdline.execute("scrapy crawl 名称".split())