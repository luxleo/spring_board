<script setup lang="ts">
import {onMounted, ref} from "vue";
import axios from 'axios'
import {useRouter} from "vue-router";

const props = defineProps({
  postId:{
    type:[Number,String],
    require:true,
  }
})
const post = ref({
  postId:-1,
  title:"",
  content:""
})
onMounted(()=>{
  axios.get(`/api/posts/${props.postId}`).then(res=>{
    post.value = res.data
  })
})
const router = useRouter()
const edit = () => {
  axios.patch(`/api/posts/${props.postId}`,post.value)
      .then(()=>router.replace({name:"home"}))
}
</script>
<template>
  <div>
    <el-input v-model="post.title" />
  </div>

  <div class="mt-2">
    <el-input v-model="post.content" type="textarea" rows="15" />
  </div>

  <div class="mt-2 d-flex justify-content-end">
    <el-button type="warning" @click="edit()">수정완료</el-button>
  </div>
</template>

<style></style>