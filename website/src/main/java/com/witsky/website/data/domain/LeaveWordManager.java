package com.witsky.website.data.domain;

import com.witsky.website.common.UpdateBuilder;
import com.witsky.website.data.dto.PageParamDTO;
import com.witsky.website.data.po.leaveWord.*;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.*;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author YSJ
 * @date 2022/07/21 09:05
 */
@Repository
public class LeaveWordManager {

    @Resource
    private MongoTemplate mongoTemplate;

    public LeaveWord insert(LeaveWord leaveWord){

        LeaveWord insert = mongoTemplate.insert(leaveWord);
        return insert;

    }


    public List<LeaveWord> findAll() {
        return mongoTemplate.findAll(LeaveWord.class);
    }

    public void updateClassify(long id, LeaveWordClassifyType type) {
        mongoTemplate.updateFirst(Query.query(Criteria.where("id").is(id)),
                UpdateBuilder.newBuilder().set("classifyType", type.toString()).build(),
                LeaveWord.class);
    }

    public void deleteClassify(long id) {
        mongoTemplate.remove(Query.query(Criteria.where("id").is(id)), LeaveWord.class);
    }

    public Optional<LeaveWord> getById(long id) {
        LeaveWord leaveWord = mongoTemplate.findById(id, LeaveWord.class);
        if (leaveWord == null){
            Optional.empty();
        }
        return Optional.of(leaveWord);
    }


    public int countAll() {
        long count = mongoTemplate.count(new Query(), LeaveWord.class);
        return (int)count;
    }

    public List<LeaveWord> getByConditions(PageParamDTO param) {
        Query query = new Query();
        query.skip((long) (param.getPageNo() - 1) * param.getPageSize());
        query.limit(param.getPageSize());
        query.with(Sort.by(
                Sort.Order.desc("issueTime")
        ));
        List<LeaveWord> leaveWordList = mongoTemplate.find(query, LeaveWord.class);
        return leaveWordList;

    }
}
