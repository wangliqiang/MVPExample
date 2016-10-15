package com.app.simplemvp.model;

import java.util.List;

/**
 * Created by 王立强 on 2016/10/10.
 */

public class MovieDetailInfo {

    /**
     * max : 10
     * average : 9.5
     * stars : 50
     * min : 0
     */

    private RatingBean rating;
    /**
     * rating : {"max":10,"average":9.5,"stars":"50","min":0}
     * reviews_count : 3750
     * wish_count : 58999
     * douban_site :
     * year : 1993
     * images : {"small":"https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p1910813120.jpg","large":"https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p1910813120.jpg","medium":"https://img3.doubanio.com/view/movie_poster_cover/spst/public/p1910813120.jpg"}
     * alt : https://movie.douban.com/subject/1291546/
     * id : 1291546
     * mobile_url : https://movie.douban.com/subject/1291546/mobile
     * title : 霸王别姬
     * do_count : null
     * share_url : https://m.douban.com/movie/subject/1291546
     * seasons_count : null
     * schedule_url :
     * episodes_count : null
     * countries : ["中国大陆","香港"]
     * genres : ["剧情","爱情","同性"]
     * collect_count : 674934
     * casts : [{"alt":"https://movie.douban.com/celebrity/1003494/","avatars":{"small":"https://img1.doubanio.com/img/celebrity/small/67.jpg","large":"https://img1.doubanio.com/img/celebrity/large/67.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/67.jpg"},"name":"张国荣","id":"1003494"},{"alt":"https://movie.douban.com/celebrity/1050265/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/10381.jpg","large":"https://img3.doubanio.com/img/celebrity/large/10381.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/10381.jpg"},"name":"张丰毅","id":"1050265"},{"alt":"https://movie.douban.com/celebrity/1035641/","avatars":{"small":"https://img1.doubanio.com/img/celebrity/small/1399268395.47.jpg","large":"https://img1.doubanio.com/img/celebrity/large/1399268395.47.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/1399268395.47.jpg"},"name":"巩俐","id":"1035641"},{"alt":"https://movie.douban.com/celebrity/1000905/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/46.jpg","large":"https://img3.doubanio.com/img/celebrity/large/46.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/46.jpg"},"name":"葛优","id":"1000905"}]
     * current_season : null
     * original_title : 霸王别姬
     * summary : 段小楼（张丰毅）与程蝶衣（张国荣）是一对打小一起长大的师兄弟，两人一个演生，一个饰旦，一向配合天衣无缝，尤其一出《霸王别姬》，更是誉满京城，为此，两人约定合演一辈子《霸王别姬》。但两人对戏剧与人生关系的理解有本质不同，段小楼深知戏非人生，程蝶衣则是人戏不分。
     段小楼在认为该成家立业之时迎娶了名妓菊仙（巩俐），致使程蝶衣认定菊仙是可耻的第三者，使段小楼做了叛徒，自此，三人围绕一出《霸王别姬》生出的爱恨情仇战开始随着时代风云的变迁不断升级，终酿成悲剧。?豆瓣
     * subtype : movie
     * directors : [{"alt":"https://movie.douban.com/celebrity/1023040/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/750.jpg","large":"https://img3.doubanio.com/img/celebrity/large/750.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/750.jpg"},"name":"陈凯歌","id":"1023040"}]
     * comments_count : 131764
     * ratings_count : 512424
     * aka : ["再见，我的妾","Farewell My Concubine"]
     */

    private int reviews_count;
    private int wish_count;
    private String douban_site;
    private String year;
    /**
     * small : https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p1910813120.jpg
     * large : https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p1910813120.jpg
     * medium : https://img3.doubanio.com/view/movie_poster_cover/spst/public/p1910813120.jpg
     */

    private ImagesBean images;
    private String alt;
    private String id;
    private String mobile_url;
    private String title;
    private Object do_count;
    private String share_url;
    private Object seasons_count;
    private String schedule_url;
    private Object episodes_count;
    private int collect_count;
    private Object current_season;
    private String original_title;
    private String summary;
    private String subtype;
    private int comments_count;
    private int ratings_count;
    private List<String> countries;
    private List<String> genres;
    /**
     * alt : https://movie.douban.com/celebrity/1003494/
     * avatars : {"small":"https://img1.doubanio.com/img/celebrity/small/67.jpg","large":"https://img1.doubanio.com/img/celebrity/large/67.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/67.jpg"}
     * name : 张国荣
     * id : 1003494
     */

    private List<CastsBean> casts;
    /**
     * alt : https://movie.douban.com/celebrity/1023040/
     * avatars : {"small":"https://img3.doubanio.com/img/celebrity/small/750.jpg","large":"https://img3.doubanio.com/img/celebrity/large/750.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/750.jpg"}
     * name : 陈凯歌
     * id : 1023040
     */

    private List<DirectorsBean> directors;
    private List<String> aka;

    public RatingBean getRating() {
        return rating;
    }

    public void setRating(RatingBean rating) {
        this.rating = rating;
    }

    public int getReviews_count() {
        return reviews_count;
    }

    public void setReviews_count(int reviews_count) {
        this.reviews_count = reviews_count;
    }

    public int getWish_count() {
        return wish_count;
    }

    public void setWish_count(int wish_count) {
        this.wish_count = wish_count;
    }

    public String getDouban_site() {
        return douban_site;
    }

    public void setDouban_site(String douban_site) {
        this.douban_site = douban_site;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public ImagesBean getImages() {
        return images;
    }

    public void setImages(ImagesBean images) {
        this.images = images;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobile_url() {
        return mobile_url;
    }

    public void setMobile_url(String mobile_url) {
        this.mobile_url = mobile_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getDo_count() {
        return do_count;
    }

    public void setDo_count(Object do_count) {
        this.do_count = do_count;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public Object getSeasons_count() {
        return seasons_count;
    }

    public void setSeasons_count(Object seasons_count) {
        this.seasons_count = seasons_count;
    }

    public String getSchedule_url() {
        return schedule_url;
    }

    public void setSchedule_url(String schedule_url) {
        this.schedule_url = schedule_url;
    }

    public Object getEpisodes_count() {
        return episodes_count;
    }

    public void setEpisodes_count(Object episodes_count) {
        this.episodes_count = episodes_count;
    }

    public int getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(int collect_count) {
        this.collect_count = collect_count;
    }

    public Object getCurrent_season() {
        return current_season;
    }

    public void setCurrent_season(Object current_season) {
        this.current_season = current_season;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public int getRatings_count() {
        return ratings_count;
    }

    public void setRatings_count(int ratings_count) {
        this.ratings_count = ratings_count;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<CastsBean> getCasts() {
        return casts;
    }

    public void setCasts(List<CastsBean> casts) {
        this.casts = casts;
    }

    public List<DirectorsBean> getDirectors() {
        return directors;
    }

    public void setDirectors(List<DirectorsBean> directors) {
        this.directors = directors;
    }

    public List<String> getAka() {
        return aka;
    }

    public void setAka(List<String> aka) {
        this.aka = aka;
    }

    public static class RatingBean {
        private int max;
        private double average;
        private String stars;
        private int min;

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public double getAverage() {
            return average;
        }

        public void setAverage(double average) {
            this.average = average;
        }

        public String getStars() {
            return stars;
        }

        public void setStars(String stars) {
            this.stars = stars;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }
    }

    public static class ImagesBean {
        private String small;
        private String large;
        private String medium;

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }
    }

    public static class CastsBean {
        private String alt;
        /**
         * small : https://img1.doubanio.com/img/celebrity/small/67.jpg
         * large : https://img1.doubanio.com/img/celebrity/large/67.jpg
         * medium : https://img1.doubanio.com/img/celebrity/medium/67.jpg
         */

        private AvatarsBean avatars;
        private String name;
        private String id;

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public AvatarsBean getAvatars() {
            return avatars;
        }

        public void setAvatars(AvatarsBean avatars) {
            this.avatars = avatars;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class AvatarsBean {
            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }
    }

    public static class DirectorsBean {
        private String alt;
        /**
         * small : https://img3.doubanio.com/img/celebrity/small/750.jpg
         * large : https://img3.doubanio.com/img/celebrity/large/750.jpg
         * medium : https://img3.doubanio.com/img/celebrity/medium/750.jpg
         */

        private AvatarsBean avatars;
        private String name;
        private String id;

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public AvatarsBean getAvatars() {
            return avatars;
        }

        public void setAvatars(AvatarsBean avatars) {
            this.avatars = avatars;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class AvatarsBean {
            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }
    }
}
