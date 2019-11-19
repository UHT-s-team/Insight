package com.UHT.Insight.daoimpl;

import com.UHT.Insight.daoImpl.GameDaoImpl;
import com.UHT.Insight.pojo.Game;
import org.junit.Test;

import java.util.List;

public class GameTest {
    private GameDaoImpl gameDaoImpl=new GameDaoImpl();
    @Test
    public void saveGame(){
        Game game=new Game(222,
                 "香肠派对",
               "厦门真有趣信息科技有限公司",
                "肠友们！各就各位，飞翔海盗团赛季开启，让我们帅气登船(๑•̀ㅂ•́)و✧\n\n1. 季票系统，福利多多，多玩多得，各类海盗团主题的道具等您来拿\n2. 新增移动飞行海盗船关卡，准备好登船了吗？\n3. 全新战场，8v8的团队竞技模式新增地图“温泉山庄”，度假期间也要成为派对之王！\n\n除此之外，在《香肠派对》您还能体会到到酣畅、硬核的战斗系统。游戏中的枪械有着真实的弹道下坠、屏息系统；同时，游戏战场中包含信号枪、复活机、战术掩体系统，考验着队伍间的默契程度。\n\n但战场中不止战斗，您能在游戏中处处感受到欢乐与可爱。在这里您可以在皮皮球、滑索上唱、跳、开火等操作，也可以二段跳躲过敌人的精准射击；你可以套上泳圈在水中与别人钢枪；在被击倒后，您将变成哭嘤嘤的小肠肠。您也可以靠着加油动作扶起倒在地上的队友。\n\n游戏里贱萌的外观系统，能助您成为最具人气的小肠肠。游戏中独特的派对卡系统，记录着您数据、装扮与成就，让其他肠肠感受您厉（ke）害（ai）；也提供了锦鲤鱼、赛博朋克风格、女仆等搞怪套装以及打啵、美少女变身等贱萌动作，还提供了举白裤裤投降、委屈哭哭等气泡表情，供您和其他肠肠互动。\n\n在这里，您将靠着 “皮” 与“阔爱”，征战百人战场，成为派对之王！",
                107389,
                107389,
                "1.1.0",
                 7.6f,
                "射击，多人，吃鸡，联机，战斗，中文，多人在线，冒险",
                "编辑推荐",
                44685193,
                 8640737,
                "无");
//        Game game=new Game(588811,"小爱童鞋","哈喽小爱","dffd",1212,2323,"1.1.1",10.1f,"asdsad","dsadsad",23213,23123,"空");
        int i=gameDaoImpl.saveGame(game);
        System.out.println(i);

    }
    @Test
    public void gameFindAll(){
        //执行查询所有方法
        List<Game> posts=gameDaoImpl.findAll();
        for(Game game : posts){
            System.out.println(game);
        }

    }
    @Test
    public void findGameById(){
          System.out.println(gameDaoImpl.findGameById(1).toString());
    }
    @Test
    public void deleteGameById(){
        System.out.println(gameDaoImpl.deleteGameById(1));
    }
    @Test
    public void updateGame(){
        Game game=new Game(588811,
                "香肠派对",
                "厦门真有趣信息科技有限公司",
                "肠友们！各就各位，飞翔海盗团赛季开启，让我们帅气登船(๑•̀ㅂ•́)و✧\n\n1. 季票系统，福利多多，多玩多得，各类海盗团主题的道具等您来拿\n2. 新增移动飞行海盗船关卡，准备好登船了吗？\n3. 全新战场，8v8的团队竞技模式新增地图“温泉山庄”，度假期间也要成为派对之王！\n\n除此之外，在《香肠派对》您还能体会到到酣畅、硬核的战斗系统。游戏中的枪械有着真实的弹道下坠、屏息系统；同时，游戏战场中包含信号枪、复活机、战术掩体系统，考验着队伍间的默契程度。\n\n但战场中不止战斗，您能在游戏中处处感受到欢乐与可爱。在这里您可以在皮皮球、滑索上唱、跳、开火等操作，也可以二段跳躲过敌人的精准射击；你可以套上泳圈在水中与别人钢枪；在被击倒后，您将变成哭嘤嘤的小肠肠。您也可以靠着加油动作扶起倒在地上的队友。\n\n游戏里贱萌的外观系统，能助您成为最具人气的小肠肠。游戏中独特的派对卡系统，记录着您数据、装扮与成就，让其他肠肠感受您厉（ke）害（ai）；也提供了锦鲤鱼、赛博朋克风格、女仆等搞怪套装以及打啵、美少女变身等贱萌动作，还提供了举白裤裤投降、委屈哭哭等气泡表情，供您和其他肠肠互动。\n\n在这里，您将靠着 “皮” 与“阔爱”，征战百人战场，成为派对之王！",
                107389,
                107389,
                "1.1.0",
                7.6f,
                "射击，多人，吃鸡，联机，战斗，中文，多人在线，冒险",
                "编辑推荐",
                44685193,
                8640737,
                "无");
        System.out.println(gameDaoImpl.updateGame(game));
    }
    @Test
    public void selectGameListCountLikeName(){
        Game game=new Game("1","1","1");
        System.out.println(gameDaoImpl.selectGameListLikeName(game));
    }
    @Test
    public void selectGameListLikeName(){
        Game game=new Game();
        System.out.println(gameDaoImpl.selectGameListCountLikeName(game));
    }

}
