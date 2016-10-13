package studio.baxia.fo.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import studio.baxia.fo.BaseTest;
import studio.baxia.fo.common.Constant;
import studio.baxia.fo.common.PageConfig;
import studio.baxia.fo.pojo.Article;

import java.util.Date;
import java.util.List;

/**
 * Created by Pan on 2016/10/13.
 */
public class ArticleDaoTest extends BaseTest {

    @Autowired
    private IArticleDao iArticleDao;

    @Test
    public void testInsert() {
        Article article = new Article();
        article.setTitle("博客初建02");
        article.setSummary("本人博客开篇，网站初建，欢迎大家关注，多交流。02");
        article.setContent("hello，大家好，欢迎来到我的博客网站，希望大家多沟通交流。谢谢大家。02");
        article.setAuthorId(1);
        article.setCategoryIds("1/5/6/");
        article.setTagIds("1/");
        article.setStatus(Constant.ACTICLE_STATUS_DRAFT);
        article.setWriteTime(new Date());
//        article.setPubTime(new Date());
        Integer result = iArticleDao.insert(article);
        methodName = new Throwable().getStackTrace()[0].getMethodName();
        printResultStr(methodName, null, result);
    }

    @Test
    public void testSelectById() {
        Article result = iArticleDao.selectById(1);
        methodName = new Throwable().getStackTrace()[0].getMethodName();
        printResultStr(methodName, null, result);
    }

    @Test
    public void testSelectBy(){
        Article article = new Article();
        article.setTitle("博客初建");
        article.setAuthorId(1);
        article.setCategoryIds("5/");
        article.setTagIds("1/");
        List<Article> result = iArticleDao.selectBy(article,new PageConfig(1,10));
        methodName = new Throwable().getStackTrace()[0].getMethodName();
        printResultStr(methodName, null, result);
    }


}
