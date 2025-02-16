 //검색 창->BM25알고리즘으로 구현-> 입력한 키워드와 제목이 유사한 게시글부터 정렬해 보여줌

 //게시글 리스트: retrieve->기본적으로 한 페이지에 10개의 게시글들의 제목, 게시날짜가 보인다.(날짜가 최근인 순부터 정렬)
 //게시글 제목을 누르면->그 제목을 가지고 날짜를 가진 게시글을 db에서 찾는다->retrieve->게시글의 날짜, 제목, 참여한 사람들의 이름, 내용이 나온다.
import { Paper } from "@mui/material";
import React from "react";
import { useState,useEffect } from "react";


const CBC=()=>{
    const [articles, setArticles]=useState([]);
    useEffect(()=>{
        const requestOptions={
            method:"GET",
            headers:{"Content-Type":"application/json"}
        };

        fetch("http://localhost:8080/communityboard/common",requestOptions)
        .then((response)=>response.json())
        .then(
            (response)=>{setArticles(response.data)},
            (error)=>{setArticles({error})}
        );
    },[]);

    let articlelist=articles.length&&(
        <Paper style={{margin:15}}>
            <List>
                {articles.map((article,idx)=><></>)}
            </List>
        </Paper>
    );

    return(
        <div>

        </div>
    );
 };

export default CBC;