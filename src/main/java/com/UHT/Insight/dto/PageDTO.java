package com.UHT.Insight.dto;

import com.UHT.Insight.pojo.Game;
import com.UHT.Insight.pojo.GameTouser;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PageDTO<T> {
    private List<T> data;
    private Integer currentPage;
    private Integer totalPage;
    private boolean showPrevious;
    private boolean showNext;
/*    private boolean showFirstPage;
    private boolean showEndPage;
    private List<Integer> pages=new ArrayList<>();
    */

    public void setPage(Integer totalPage, Integer currentPage) {
        this.totalPage = totalPage;
        this.currentPage =currentPage;

   /*     pages.add(page);
        //D当前页面
        for (int i=1;i<=3;i++){
            if(page -i >0){
                pages.add(0,page -i);
            }

            if (page +i <=totalPage){
                pages.add(page+i);
            }
        }
*/

        if(currentPage == 1){
                showPrevious = false;
            }else {
                showPrevious=true;
            }

            if(currentPage== totalPage){
                showNext = false;
            }else {
                showNext=true;
        }

     /*   if(pages.contains(1)){
            showFirstPage=false;
        }else {
            showFirstPage=true;
        }

        if(pages.contains(totalPage)){
            showEndPage=false;
        }else {
            showEndPage=true;
        }*/
    }

}
