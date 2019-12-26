from scrapy import cmdline
 
cmdline.execute("scrapy crawl tap  –a gameNub=168332 -s LOG_FILE=xx.log".split())
