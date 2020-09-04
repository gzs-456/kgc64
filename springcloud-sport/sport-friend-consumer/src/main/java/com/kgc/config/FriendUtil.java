package com.kgc.config;

import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.IndicesClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class FriendUtil {
    @Autowired
    private RestHighLevelClient restHighLevelClient;
    //创建索引和映射
    public void createIndex() throws  Exception{
        System.out.println("创建索引和映射");
        //创建索引 名字
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("tb_friend");
        //索引设置
        createIndexRequest.settings(Settings.builder().put("number_of_shards", 1).put("number_of_replicas", 0));
        //创建映射
        //设置映射
        createIndexRequest.mapping("doc","{\n" +
                "\t\"properties\": {\n" +
                "\t\t\"id\": {\n" +
                "\t\t\t\"type\": \"integer\"\n" +
                "\t\t},\n" +
                "\t\t\"userid\": {\n" +
                "\t\t\t\"type\": \"keyword\"\n" +
                "\t\t},\n" +
                "\t\t\"friendid\": {\n" +
                "\t\t\t\"type\": \"keyword\"\n" +
                "\t\t},\n" +
                "\t\t\"bz\": {\n" +
                "\t\t\t\"type\": \"text\",\n" +
                "\t\t\t\"analyzer\": \"ik_max_word\",\n" +
                "\t\t\t\"search_analyzer\": \"ik_smart\"\n" +
                "\t\t},\n" +
                "\t\t\"islike\": {\n" +
                "\t\t\t\"type\": \"keyword\"\n" +
                "\t\t}\n" +
                "\t}\n" +
                "}", XContentType.JSON);
        //创建索引操作客户端
        IndicesClient indices = restHighLevelClient.indices();
        //创建并返回一个响应对象
        CreateIndexResponse createIndexResponse = indices.create(createIndexRequest);
        //得到响应结果
        boolean acknowledged = createIndexResponse.isAcknowledged();
        System.out.println(acknowledged);
        System.out.println("创建成功");
    }

    //删除
    public void deleteIndex() {
        try {
            //场景删除请求对象
            DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("tb_friend");
            //通过高级对象获取索引对象,执行删除并获取到响应对象
            DeleteIndexResponse deleteIndexResponse = restHighLevelClient.indices().delete(deleteIndexRequest);
            //获取执行的结果是否成功
            boolean acknowledged = deleteIndexResponse.isAcknowledged();
            System.out.println(acknowledged);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //添加
    public void addDoc() throws IOException {
        //准备json数据
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("id",3);
        jsonMap.put("userid", "a3");
        jsonMap.put("friendid", "b3");
        jsonMap.put("bz", "a3b3");
        jsonMap.put("islike", "0");
        //创建请求对象 库，表 id可加可不加
        IndexRequest indexRequest = new IndexRequest("tb_friend", "doc"+"");
        //指定索引文档内容
        indexRequest.source(jsonMap);
        //索引响应对象
        IndexResponse indexResponse = restHighLevelClient.index(indexRequest);
        //获取响应结果
        DocWriteResponse.Result result = indexResponse.getResult();
        System.out.println(result);
    }

    //分页
    public void searchpage(Integer pageIndex,Integer pageSize) throws IOException {
        //创建查询请求对象
        SearchRequest searchRequest = new SearchRequest("tb_friend");
        searchRequest.types("doc");
        //构建查询方式
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //查询所有数据
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        //分页参数
        searchSourceBuilder.from((pageIndex - 1) * pageSize);
        searchSourceBuilder.size(pageSize);
        //过滤查询的列
        //参数1：可以显示的列
        //参数2：禁止显示的列
        //searchSourceBuilder.fetchSource(new String[]{"name", "studymodel", "price"}, new String[]{});
        //将构建对象存储到request对象中去
        searchRequest.source(searchSourceBuilder);
        //执行查询并获取响应对象
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest);
        //获取索引的hits
        SearchHits hits = searchResponse.getHits();
        //获取到数组对象(存储的数据)
        SearchHit[] searchHits = hits.getHits();
        for (SearchHit hit : searchHits) {
            String index = hit.getIndex();
            String type = hit.getType();
            String id = hit.getId();
            float score = hit.getScore();
            System.out.println("id:"+id);
            String sourceAsString = hit.getSourceAsString();
            System.out.println("index:"+index+"\t type:"+type+"\t id:"+"");
            //获取到map数据
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            int fid=Integer.parseInt((String) sourceAsMap.get("id"));
            String userid = (String) sourceAsMap.get("userid");
            String friendid = (String) sourceAsMap.get("friendid");
            String bz = (String) sourceAsMap.get("content");
            String islike=(String)sourceAsMap.get("islike");
            System.out.println(fid+"\t"+userid+"\t"+friendid+"\t"+bz+"\t"+islike);

        }
    }
}
