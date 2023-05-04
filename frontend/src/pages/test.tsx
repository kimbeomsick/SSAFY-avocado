import styled from "@emotion/styled";
import { useRouter } from "next/router";
import { Stack } from "@mui/material";
import Grid from "@mui/material/Grid";
import Typography from "@mui/material/Typography";
import Chip from "@mui/material/Chip";
import Image from "next/image";
import Rating from "@mui/material/Rating";

import { useState } from "react";

import { Pie, Doughnut } from "react-chartjs-2";
import { Bubble } from "react-chartjs-2";
import { IconButton } from "@mui/material";
import BookmarkBorderOutlinedIcon from "@mui/icons-material/BookmarkBorderOutlined";
import BookmarkOutlinedIcon from "@mui/icons-material/BookmarkOutlined";
import { BlockText, InlineText } from "../components/atoms";
import { ProductDetailImage, ProductCardsRow } from "../components/oranisms";
import { ChartPersonalColor } from "../components/oranisms/charts";

import FormControl from "@mui/material";
import TextField from "@mui/material/TextField";
import Button from "@mui/material/Button";
import SendIcon from "@mui/icons-material/Send";
import { useRef } from "react";
import { ReviewInput,Review } from "../components/molecues";



const ProductReview = () =>{

  // 더미 댓글 데이터
  const data = [
    {
      name:"김싸피",
      avatar:"spring_man",
      mbti:"ISFP",
      personal_color:"봄 라이트",
      rate:"4",
      content:"사이즈가 작아요 크게 주문하세요"
    },
    {
      name:"김싸피",
      avatar:"spring_man",
      mbti:"ISFP",
      personal_color:"봄 라이트",
      rate:"4",
      content:"사이즈가 작아요 크게 주문하세요"
    },
    {
      name:"김싸피",
      avatar:"spring_man",
      mbti:"ISFP",
      personal_color:"봄 라이트",
      rate:"4",
      content:"사이즈가 작아요 크게 주문하세요"
    },
    {
      name:"김싸피",
      avatar:"spring_man",
      mbti:"ISFP",
      personal_color:"봄 라이트",
      rate:"4",
      content:"사이즈가 작아요 크게 주문하세요"
    },
    {
      name:"김싸피",
      avatar:"spring_man",
      mbti:"ISFP",
      personal_color:"봄 라이트",
      rate:"4",
      content:"사이즈가 작아요 크게 주문하세요"
    },
  ]
  


  return(
    <>
    <ReviewInput/>
    {
      data ? (
        data.map((item:any, i:number)=>(
          <Review name={item.name} avatar={item.avatar} mbti={item.mbti} personal_color={item.personal_color} rate={item.rate} content={item.content} key={i}/>
      ))
        ):(
          <BlockText color="grey" type="L">리뷰가 없습니다.</BlockText>
      )
    }

    </>
  )
}


export default ProductReview 

const Background = styled.div`

`