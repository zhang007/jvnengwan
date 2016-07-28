package com.example.majunpeng.jvnengwan.bean;

import java.util.List;

/**
 * Created by zhangfan on 2016/7/28.
 */
public class MyLiveVideoBean {
    private RecLiveBean rec_live;
    private ConLiveBean con_live;
    private HotLiveBean hot_live;

    public RecLiveBean getRec_live() {
        return rec_live;
    }

    public void setRec_live(RecLiveBean rec_live) {
        this.rec_live = rec_live;
    }

    public ConLiveBean getCon_live() {
        return con_live;
    }

    public void setCon_live(ConLiveBean con_live) {
        this.con_live = con_live;
    }

    public HotLiveBean getHot_live() {
        return hot_live;
    }

    public void setHot_live(HotLiveBean hot_live) {
        this.hot_live = hot_live;
    }

    public static class RecLiveBean {
        private String status;
        private String pageNo;
        private String pageSize;
        private String has_next;
        private List<DataListBean> data_list;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getPageNo() {
            return pageNo;
        }

        public void setPageNo(String pageNo) {
            this.pageNo = pageNo;
        }

        public String getPageSize() {
            return pageSize;
        }

        public void setPageSize(String pageSize) {
            this.pageSize = pageSize;
        }

        public String getHas_next() {
            return has_next;
        }

        public void setHas_next(String has_next) {
            this.has_next = has_next;
        }

        public List<DataListBean> getData_list() {
            return data_list;
        }

        public void setData_list(List<DataListBean> data_list) {
            this.data_list = data_list;
        }

        public static class DataListBean {
            private List<MyArrayListBean> myArrayList;

            public List<MyArrayListBean> getMyArrayList() {
                return myArrayList;
            }

            public void setMyArrayList(List<MyArrayListBean> myArrayList) {
                this.myArrayList = myArrayList;
            }

            public static class MyArrayListBean {

                private MapBean map;

                public MapBean getMap() {
                    return map;
                }

                public void setMap(MapBean map) {
                    this.map = map;
                }

                public static class MapBean {
                    private String follows;
                    private String gamename_enum;
                    private String channel_enum;
                    private String rawcoverimage;
                    private String off_enum;
                    private String sourcename;
                    private String id;
                    private String roomid;
                    private String sourcesite;
                    private String title;
                    private String allnum;
                    private String queryname_enum;
                    private String invalid;
                    private String nocopyright;
                    private String name;
                    private String usehtml5;
                    private String fixrank;
                    private String sogoupv;
                    private String fullscreenurl;
                    private String gamecoverimage_width;
                    private String html5_allowpopup;
                    private String commentator;
                    private String renqi;
                    private String viewers;
                    private String html5_autoplay;
                    private String url;
                    private String rawcommentatorimage;
                    private String gamecoverimage_height;
                    private String html5_url;
                    private String finalrank;
                    private String infotype;
                    private String sourcename_enum;
                    private String channel;

                    public String getFollows() {
                        return follows;
                    }

                    public void setFollows(String follows) {
                        this.follows = follows;
                    }

                    public String getGamename_enum() {
                        return gamename_enum;
                    }

                    public void setGamename_enum(String gamename_enum) {
                        this.gamename_enum = gamename_enum;
                    }

                    public String getChannel_enum() {
                        return channel_enum;
                    }

                    public void setChannel_enum(String channel_enum) {
                        this.channel_enum = channel_enum;
                    }

                    public String getRawcoverimage() {
                        return rawcoverimage;
                    }

                    public void setRawcoverimage(String rawcoverimage) {
                        this.rawcoverimage = rawcoverimage;
                    }

                    public String getOff_enum() {
                        return off_enum;
                    }

                    public void setOff_enum(String off_enum) {
                        this.off_enum = off_enum;
                    }

                    public String getSourcename() {
                        return sourcename;
                    }

                    public void setSourcename(String sourcename) {
                        this.sourcename = sourcename;
                    }

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public String getRoomid() {
                        return roomid;
                    }

                    public void setRoomid(String roomid) {
                        this.roomid = roomid;
                    }

                    public String getSourcesite() {
                        return sourcesite;
                    }

                    public void setSourcesite(String sourcesite) {
                        this.sourcesite = sourcesite;
                    }

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getAllnum() {
                        return allnum;
                    }

                    public void setAllnum(String allnum) {
                        this.allnum = allnum;
                    }

                    public String getQueryname_enum() {
                        return queryname_enum;
                    }

                    public void setQueryname_enum(String queryname_enum) {
                        this.queryname_enum = queryname_enum;
                    }

                    public String getInvalid() {
                        return invalid;
                    }

                    public void setInvalid(String invalid) {
                        this.invalid = invalid;
                    }

                    public String getNocopyright() {
                        return nocopyright;
                    }

                    public void setNocopyright(String nocopyright) {
                        this.nocopyright = nocopyright;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getUsehtml5() {
                        return usehtml5;
                    }

                    public void setUsehtml5(String usehtml5) {
                        this.usehtml5 = usehtml5;
                    }

                    public String getFixrank() {
                        return fixrank;
                    }

                    public void setFixrank(String fixrank) {
                        this.fixrank = fixrank;
                    }

                    public String getSogoupv() {
                        return sogoupv;
                    }

                    public void setSogoupv(String sogoupv) {
                        this.sogoupv = sogoupv;
                    }

                    public String getFullscreenurl() {
                        return fullscreenurl;
                    }

                    public void setFullscreenurl(String fullscreenurl) {
                        this.fullscreenurl = fullscreenurl;
                    }

                    public String getGamecoverimage_width() {
                        return gamecoverimage_width;
                    }

                    public void setGamecoverimage_width(String gamecoverimage_width) {
                        this.gamecoverimage_width = gamecoverimage_width;
                    }

                    public String getHtml5_allowpopup() {
                        return html5_allowpopup;
                    }

                    public void setHtml5_allowpopup(String html5_allowpopup) {
                        this.html5_allowpopup = html5_allowpopup;
                    }

                    public String getCommentator() {
                        return commentator;
                    }

                    public void setCommentator(String commentator) {
                        this.commentator = commentator;
                    }

                    public String getRenqi() {
                        return renqi;
                    }

                    public void setRenqi(String renqi) {
                        this.renqi = renqi;
                    }

                    public String getViewers() {
                        return viewers;
                    }

                    public void setViewers(String viewers) {
                        this.viewers = viewers;
                    }

                    public String getHtml5_autoplay() {
                        return html5_autoplay;
                    }

                    public void setHtml5_autoplay(String html5_autoplay) {
                        this.html5_autoplay = html5_autoplay;
                    }

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }

                    public String getRawcommentatorimage() {
                        return rawcommentatorimage;
                    }

                    public void setRawcommentatorimage(String rawcommentatorimage) {
                        this.rawcommentatorimage = rawcommentatorimage;
                    }

                    public String getGamecoverimage_height() {
                        return gamecoverimage_height;
                    }

                    public void setGamecoverimage_height(String gamecoverimage_height) {
                        this.gamecoverimage_height = gamecoverimage_height;
                    }

                    public String getHtml5_url() {
                        return html5_url;
                    }

                    public void setHtml5_url(String html5_url) {
                        this.html5_url = html5_url;
                    }

                    public String getFinalrank() {
                        return finalrank;
                    }

                    public void setFinalrank(String finalrank) {
                        this.finalrank = finalrank;
                    }

                    public String getInfotype() {
                        return infotype;
                    }

                    public void setInfotype(String infotype) {
                        this.infotype = infotype;
                    }

                    public String getSourcename_enum() {
                        return sourcename_enum;
                    }

                    public void setSourcename_enum(String sourcename_enum) {
                        this.sourcename_enum = sourcename_enum;
                    }

                    public String getChannel() {
                        return channel;
                    }

                    public void setChannel(String channel) {
                        this.channel = channel;
                    }
                }
            }
        }
    }

    public static class ConLiveBean {
        private String status;
        private String pageNo;
        private String pageSize;
        private String has_next;
        private List<DataListBean> data_list;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getPageNo() {
            return pageNo;
        }

        public void setPageNo(String pageNo) {
            this.pageNo = pageNo;
        }

        public String getPageSize() {
            return pageSize;
        }

        public void setPageSize(String pageSize) {
            this.pageSize = pageSize;
        }

        public String getHas_next() {
            return has_next;
        }

        public void setHas_next(String has_next) {
            this.has_next = has_next;
        }

        public List<DataListBean> getData_list() {
            return data_list;
        }

        public void setData_list(List<DataListBean> data_list) {
            this.data_list = data_list;
        }

        public static class DataListBean {
            /**
             * map : {"follows":0,"gamename_enum":1007,"channel_enum":1,"rawcoverimage":"https://rpic.douyucdn.cn/z1607/27/13/70231_160727131013.jpg","off_enum":0,"sourcename":"斗鱼","id":"13422440357078098743","roomid":70231,"sourcesite":"www.douyu.com","title":"H1Z1-10000000000000死","allnum":0,"queryname_enum":40,"invalid":1,"nocopyright":0,"name":"主机游戏","usehtml5":1,"fixrank":0,"sogoupv":20495,"fullscreenurl":"http://staticlive.douyutv.com/common/share/play.swf?room_id=70231","gamecoverimage_width":0,"html5_allowpopup":1,"commentator":"恶魔qq","renqi":12180,"viewers":83000,"html5_autoplay":0,"url":"http://www.douyu.com/70231","rawcommentatorimage":"http://uc.douyutv.com/upload/avatar/002/48/08/08_avatar_middle.jpg?rltime","gamecoverimage_height":0,"html5_url":"http://m.douyu.com/70231","finalrank":1,"infotype":"live","sourcename_enum":1,"channel":"游戏"}
             */

            private List<MyArrayListBean> myArrayList;

            public List<MyArrayListBean> getMyArrayList() {
                return myArrayList;
            }

            public void setMyArrayList(List<MyArrayListBean> myArrayList) {
                this.myArrayList = myArrayList;
            }

            public static class MyArrayListBean {

                private MapBean map;

                public MapBean getMap() {
                    return map;
                }

                public void setMap(MapBean map) {
                    this.map = map;
                }

                public static class MapBean {
                    private String follows;
                    private String gamename_enum;
                    private String channel_enum;
                    private String rawcoverimage;
                    private String off_enum;
                    private String sourcename;
                    private String id;
                    private String roomid;
                    private String sourcesite;
                    private String title;
                    private String allnum;
                    private String queryname_enum;
                    private String invalid;
                    private String nocopyright;
                    private String name;
                    private String usehtml5;
                    private String fixrank;
                    private String sogoupv;
                    private String fullscreenurl;
                    private String gamecoverimage_width;
                    private String html5_allowpopup;
                    private String commentator;
                    private String renqi;
                    private String viewers;
                    private String html5_autoplay;
                    private String url;
                    private String rawcommentatorimage;
                    private String gamecoverimage_height;
                    private String html5_url;
                    private String finalrank;
                    private String infotype;
                    private String sourcename_enum;
                    private String channel;

                    public String getFollows() {
                        return follows;
                    }

                    public void setFollows(String follows) {
                        this.follows = follows;
                    }

                    public String getGamename_enum() {
                        return gamename_enum;
                    }

                    public void setGamename_enum(String gamename_enum) {
                        this.gamename_enum = gamename_enum;
                    }

                    public String getChannel_enum() {
                        return channel_enum;
                    }

                    public void setChannel_enum(String channel_enum) {
                        this.channel_enum = channel_enum;
                    }

                    public String getRawcoverimage() {
                        return rawcoverimage;
                    }

                    public void setRawcoverimage(String rawcoverimage) {
                        this.rawcoverimage = rawcoverimage;
                    }

                    public String getOff_enum() {
                        return off_enum;
                    }

                    public void setOff_enum(String off_enum) {
                        this.off_enum = off_enum;
                    }

                    public String getSourcename() {
                        return sourcename;
                    }

                    public void setSourcename(String sourcename) {
                        this.sourcename = sourcename;
                    }

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public String getRoomid() {
                        return roomid;
                    }

                    public void setRoomid(String roomid) {
                        this.roomid = roomid;
                    }

                    public String getSourcesite() {
                        return sourcesite;
                    }

                    public void setSourcesite(String sourcesite) {
                        this.sourcesite = sourcesite;
                    }

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getAllnum() {
                        return allnum;
                    }

                    public void setAllnum(String allnum) {
                        this.allnum = allnum;
                    }

                    public String getQueryname_enum() {
                        return queryname_enum;
                    }

                    public void setQueryname_enum(String queryname_enum) {
                        this.queryname_enum = queryname_enum;
                    }

                    public String getInvalid() {
                        return invalid;
                    }

                    public void setInvalid(String invalid) {
                        this.invalid = invalid;
                    }

                    public String getNocopyright() {
                        return nocopyright;
                    }

                    public void setNocopyright(String nocopyright) {
                        this.nocopyright = nocopyright;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getUsehtml5() {
                        return usehtml5;
                    }

                    public void setUsehtml5(String usehtml5) {
                        this.usehtml5 = usehtml5;
                    }

                    public String getFixrank() {
                        return fixrank;
                    }

                    public void setFixrank(String fixrank) {
                        this.fixrank = fixrank;
                    }

                    public String getSogoupv() {
                        return sogoupv;
                    }

                    public void setSogoupv(String sogoupv) {
                        this.sogoupv = sogoupv;
                    }

                    public String getFullscreenurl() {
                        return fullscreenurl;
                    }

                    public void setFullscreenurl(String fullscreenurl) {
                        this.fullscreenurl = fullscreenurl;
                    }

                    public String getGamecoverimage_width() {
                        return gamecoverimage_width;
                    }

                    public void setGamecoverimage_width(String gamecoverimage_width) {
                        this.gamecoverimage_width = gamecoverimage_width;
                    }

                    public String getHtml5_allowpopup() {
                        return html5_allowpopup;
                    }

                    public void setHtml5_allowpopup(String html5_allowpopup) {
                        this.html5_allowpopup = html5_allowpopup;
                    }

                    public String getCommentator() {
                        return commentator;
                    }

                    public void setCommentator(String commentator) {
                        this.commentator = commentator;
                    }

                    public String getRenqi() {
                        return renqi;
                    }

                    public void setRenqi(String renqi) {
                        this.renqi = renqi;
                    }

                    public String getViewers() {
                        return viewers;
                    }

                    public void setViewers(String viewers) {
                        this.viewers = viewers;
                    }

                    public String getHtml5_autoplay() {
                        return html5_autoplay;
                    }

                    public void setHtml5_autoplay(String html5_autoplay) {
                        this.html5_autoplay = html5_autoplay;
                    }

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }

                    public String getRawcommentatorimage() {
                        return rawcommentatorimage;
                    }

                    public void setRawcommentatorimage(String rawcommentatorimage) {
                        this.rawcommentatorimage = rawcommentatorimage;
                    }

                    public String getGamecoverimage_height() {
                        return gamecoverimage_height;
                    }

                    public void setGamecoverimage_height(String gamecoverimage_height) {
                        this.gamecoverimage_height = gamecoverimage_height;
                    }

                    public String getHtml5_url() {
                        return html5_url;
                    }

                    public void setHtml5_url(String html5_url) {
                        this.html5_url = html5_url;
                    }

                    public String getFinalrank() {
                        return finalrank;
                    }

                    public void setFinalrank(String finalrank) {
                        this.finalrank = finalrank;
                    }

                    public String getInfotype() {
                        return infotype;
                    }

                    public void setInfotype(String infotype) {
                        this.infotype = infotype;
                    }

                    public String getSourcename_enum() {
                        return sourcename_enum;
                    }

                    public void setSourcename_enum(String sourcename_enum) {
                        this.sourcename_enum = sourcename_enum;
                    }

                    public String getChannel() {
                        return channel;
                    }

                    public void setChannel(String channel) {
                        this.channel = channel;
                    }
                }
            }
        }
    }

    public static class HotLiveBean {
        private String status;
        private String pageNo;
        private String pageSize;
        private String has_next;
        private List<DataListBean> data_list;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getPageNo() {
            return pageNo;
        }

        public void setPageNo(String pageNo) {
            this.pageNo = pageNo;
        }

        public String getPageSize() {
            return pageSize;
        }

        public void setPageSize(String pageSize) {
            this.pageSize = pageSize;
        }

        public String getHas_next() {
            return has_next;
        }

        public void setHas_next(String has_next) {
            this.has_next = has_next;
        }

        public List<DataListBean> getData_list() {
            return data_list;
        }

        public void setData_list(List<DataListBean> data_list) {
            this.data_list = data_list;
        }

        public static class DataListBean {
            private List<MyArrayListBean> myArrayList;

            public List<MyArrayListBean> getMyArrayList() {
                return myArrayList;
            }

            public void setMyArrayList(List<MyArrayListBean> myArrayList) {
                this.myArrayList = myArrayList;
            }

            public static class MyArrayListBean {
                private MapBean map;

                public MapBean getMap() {
                    return map;
                }

                public void setMap(MapBean map) {
                    this.map = map;
                }

                public static class MapBean {
                    private String follows;
                    private String gamename_enum;
                    private String channel_enum;
                    private String rawcoverimage;
                    private String off_enum;
                    private String sourcename;
                    private String id;
                    private String roomid;
                    private String sourcesite;
                    private String title;
                    private String allnum;
                    private String queryname_enum;
                    private String invalid;
                    private String nocopyright;
                    private String name;
                    private String usehtml5;
                    private String fixrank;
                    private String sogoupv;
                    private String gamecoverimage_width;
                    private String html5_allowpopup;
                    private String commentator;
                    private String renqi;
                    private String viewers;
                    private String html5_autoplay;
                    private String url;
                    private String rawcommentatorimage;
                    private String gamecoverimage_height;
                    private String html5_url;
                    private String finalrank;
                    private String infotype;
                    private String sourcename_enum;
                    private String channel;

                    public String getFollows() {
                        return follows;
                    }

                    public void setFollows(String follows) {
                        this.follows = follows;
                    }

                    public String getGamename_enum() {
                        return gamename_enum;
                    }

                    public void setGamename_enum(String gamename_enum) {
                        this.gamename_enum = gamename_enum;
                    }

                    public String getChannel_enum() {
                        return channel_enum;
                    }

                    public void setChannel_enum(String channel_enum) {
                        this.channel_enum = channel_enum;
                    }

                    public String getRawcoverimage() {
                        return rawcoverimage;
                    }

                    public void setRawcoverimage(String rawcoverimage) {
                        this.rawcoverimage = rawcoverimage;
                    }

                    public String getOff_enum() {
                        return off_enum;
                    }

                    public void setOff_enum(String off_enum) {
                        this.off_enum = off_enum;
                    }

                    public String getSourcename() {
                        return sourcename;
                    }

                    public void setSourcename(String sourcename) {
                        this.sourcename = sourcename;
                    }

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }
                    public String getRoomid() {
                        return roomid;
                    }

                    public void setRoomid(String roomid) {
                        this.roomid = roomid;
                    }

                    public String getSourcesite() {
                        return sourcesite;
                    }

                    public void setSourcesite(String sourcesite) {
                        this.sourcesite = sourcesite;
                    }

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getAllnum() {
                        return allnum;
                    }

                    public void setAllnum(String allnum) {
                        this.allnum = allnum;
                    }

                    public String getQueryname_enum() {
                        return queryname_enum;
                    }

                    public void setQueryname_enum(String queryname_enum) {
                        this.queryname_enum = queryname_enum;
                    }

                    public String getInvalid() {
                        return invalid;
                    }

                    public void setInvalid(String invalid) {
                        this.invalid = invalid;
                    }

                    public String getNocopyright() {
                        return nocopyright;
                    }

                    public void setNocopyright(String nocopyright) {
                        this.nocopyright = nocopyright;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getUsehtml5() {
                        return usehtml5;
                    }

                    public void setUsehtml5(String usehtml5) {
                        this.usehtml5 = usehtml5;
                    }

                    public String getFixrank() {
                        return fixrank;
                    }

                    public void setFixrank(String fixrank) {
                        this.fixrank = fixrank;
                    }

                    public String getSogoupv() {
                        return sogoupv;
                    }

                    public void setSogoupv(String sogoupv) {
                        this.sogoupv = sogoupv;
                    }

                    public String getGamecoverimage_width() {
                        return gamecoverimage_width;
                    }

                    public void setGamecoverimage_width(String gamecoverimage_width) {
                        this.gamecoverimage_width = gamecoverimage_width;
                    }

                    public String getHtml5_allowpopup() {
                        return html5_allowpopup;
                    }

                    public void setHtml5_allowpopup(String html5_allowpopup) {
                        this.html5_allowpopup = html5_allowpopup;
                    }

                    public String getCommentator() {
                        return commentator;
                    }

                    public void setCommentator(String commentator) {
                        this.commentator = commentator;
                    }

                    public String getRenqi() {
                        return renqi;
                    }

                    public void setRenqi(String renqi) {
                        this.renqi = renqi;
                    }

                    public String getViewers() {
                        return viewers;
                    }

                    public void setViewers(String viewers) {
                        this.viewers = viewers;
                    }

                    public String getHtml5_autoplay() {
                        return html5_autoplay;
                    }

                    public void setHtml5_autoplay(String html5_autoplay) {
                        this.html5_autoplay = html5_autoplay;
                    }

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }

                    public String getRawcommentatorimage() {
                        return rawcommentatorimage;
                    }

                    public void setRawcommentatorimage(String rawcommentatorimage) {
                        this.rawcommentatorimage = rawcommentatorimage;
                    }

                    public String getGamecoverimage_height() {
                        return gamecoverimage_height;
                    }

                    public void setGamecoverimage_height(String gamecoverimage_height) {
                        this.gamecoverimage_height = gamecoverimage_height;
                    }

                    public String getHtml5_url() {
                        return html5_url;
                    }

                    public void setHtml5_url(String html5_url) {
                        this.html5_url = html5_url;
                    }

                    public String getFinalrank() {
                        return finalrank;
                    }

                    public void setFinalrank(String finalrank) {
                        this.finalrank = finalrank;
                    }

                    public String getInfotype() {
                        return infotype;
                    }

                    public void setInfotype(String infotype) {
                        this.infotype = infotype;
                    }

                    public String getSourcename_enum() {
                        return sourcename_enum;
                    }

                    public void setSourcename_enum(String sourcename_enum) {
                        this.sourcename_enum = sourcename_enum;
                    }

                    public String getChannel() {
                        return channel;
                    }

                    public void setChannel(String channel) {
                        this.channel = channel;
                    }
                }
            }
        }
    }
}
