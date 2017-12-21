package wangbo.bawei.com.mytbdome.hompager.bean;

import java.util.List;

/**
 * author:Created by YanZhiXiong on 2017/12/6.
 */

public class BannerBean {


    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2017-03-28 21:00","title":"白衣美女","description":"华声美女","picUrl":"http://image.hnol.net/c/2017-03/28/20/201703282028406291-2228137.jpg","url":"http://bbs.voc.com.cn/mm/meinv-7726705-0-1.html"},{"ctime":"2017-03-29 09:00","title":"东方美色丽人榜（244）","description":"华声美女","picUrl":"http://image.hnol.net/c/2017-03/29/06/201703290639318281-993477.jpg","url":"http://bbs.voc.com.cn/mm/meinv-7726970-0-1.html"},{"ctime":"2017-03-29 12:00","title":"【美D共享】&#9824; 王馨瑶yanni-丽江旅拍(1)","description":"华声美女","picUrl":"http://image.hnol.net/c/2017-03/29/11/20170329112545261-2089977.jpg","url":"http://bbs.voc.com.cn/mm/meinv-7727452-0-1.html"},{"ctime":"2017-03-29 12:00","title":"【美D共享】&#9824; 刘娅希","description":"华声美女","picUrl":"http://image.hnol.net/c/2017-03/29/11/20170329111144991-2089977.jpg","url":"http://bbs.voc.com.cn/mm/meinv-7727417-0-1.html"},{"ctime":"2017-03-29 17:00","title":"【美D共享】&#9824; 七宝-每日一画","description":"华声美女","picUrl":"http://image.hnol.net/c/2017-03/29/16/201703291639564611-2089977.jpeg","url":"http://bbs.voc.com.cn/mm/meinv-7728160-0-1.html"},{"ctime":"2017-03-30 10:00","title":"【美D共享】&#9824; 默  子","description":"华声美女","picUrl":"http://image.hnol.net/c/2017-03/29/11/201703291146035621-2089977.jpg","url":"http://bbs.voc.com.cn/mm/meinv-7727504-0-1.html"},{"ctime":"2017-03-30 12:00","title":"美腿秀528（Miso 2017.03.30)","description":"华声美女","picUrl":"http://image.hnol.net/c/2017-03/30/11/201703301130515991-2285289.jpg","url":"http://bbs.voc.com.cn/mm/meinv-7729507-0-1.html"},{"ctime":"2017-03-30 12:00","title":"王熙然.妩媚可爱[06P]","description":"华声美女","picUrl":"http://image.hnol.net/c/2017-03/30/11/201703301151144661-2497165.jpg","url":"http://bbs.voc.com.cn/mm/meinv-7729559-0-1.html"},{"ctime":"2017-03-30 16:00","title":"韩丹彤《美人鱼之梦》[11P][贴图]","description":"华声美女","picUrl":"http://image.hnol.net/c/2017-03/30/12/201703301219061191-2497165.jpg","url":"http://bbs.voc.com.cn/mm/meinv-7729616-0-1.html"},{"ctime":"2017-03-30 21:00","title":"【美D共享】&#9824; Kimoe 沈欣雨","description":"华声美女","picUrl":"http://image.hnol.net/c/2017-03/29/11/201703291102116271-2089977.jpg","url":"http://bbs.voc.com.cn/mm/meinv-7727387-0-1.html"}]
     */

    private int code;
    private String msg;
    private List<NewslistBean> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NewslistBean> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewslistBean> newslist) {
        this.newslist = newslist;
    }

    public static class NewslistBean {
        /**
         * ctime : 2017-03-28 21:00
         * title : 白衣美女
         * description : 华声美女
         * picUrl : http://image.hnol.net/c/2017-03/28/20/201703282028406291-2228137.jpg
         * url : http://bbs.voc.com.cn/mm/meinv-7726705-0-1.html
         */

        private String ctime;
        private String title;
        private String description;
        private String picUrl;
        private String url;

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
