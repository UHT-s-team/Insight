from scrapy import cmdline
 
cmdline.execute("scrapy crawl tap -a gameNub=130651 -s LOG_FILE=xx.log".split())
 
#或者
#cmdline.execute("scrapy crawl 名称".split())