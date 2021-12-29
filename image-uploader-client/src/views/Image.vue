<template id='app'>
    <el-row>
    <div v-show="isLoading" class="loading_body">
      <div class="background_loading_area">
        <p>Uploading...</p>
        <template>
          <div class="container">
            <vue-loading type="spin" color="#333" :size="{ width: '50px', height: '50px' }"></vue-loading>
          </div>
        </template>
      </div>
    </div>
    <div v-show="!isLoading" class="upload_body">
      <div class="background_upload_area">
        <p class="title_font">Upload your image</p>
        <p>File should be Jpeg, Png,…</p>
        <div class="drop_area" @dragenter="dragEnter"
                        @dragleave="dragLeave"
                        @dragover.prevent
                        @drop.prevent="dropFile"
                        :class="{enter: isEnter}">
          <img src="../image/image.svg">
          <p>Drag & Drop your image here</p>
        </div>
        <p>Or</p>
        <div>
          <input type="file" ref="file" @change="changeFile" style="display:none;">
          <el-row>
            <el-button type="primary" @click="clickFileInput">Choose a file</el-button>
          </el-row>
        </div>
      </div>
    </div>
  </el-row>
</template>

<script>
import axios from 'axios'
import { VueLoading } from 'vue-loading-template'

export default {

  name: "ImagePage", // ImagePage not Image to avoid duplicate tag names
  components: {
    VueLoading
  },
  data () {
    return {
        images: [],
        isEnter: false,
        isLoading: false,
        url: "",
    }
  },
  created: async function () {
    await this.refresh()
  },
  methods: {
    clickFileInput(){
      this.$refs.file.click();
    },
    dragEnter(){
      this.isEnter = true
    },
    dragLeave(){
      this.isEnter = false
    },
    dropFile(){
      this.isEnter = false
      this.uploadFile(event.dataTransfer.files[0])
    },
    changeFile(e){
      this.uploadFile(e.target.files[0])
    },
    uploadFile: async function(file){
      this.isLoading = true
      const _sleep = (ms) => new Promise((resolve) => setTimeout(resolve, ms));
      await _sleep(1000);
      
      let file_name = file.name;

      let reader = new FileReader();
      reader.readAsBinaryString(file);
      reader.onload = function(e){
        var send_data = {
            request: {
                name: undefined,
                file: undefined,
            }
        }
        send_data.name = file_name
        send_data.file = e.target.result
        axios.post('http://localhost:8080/', send_data)
      };

      this.url = URL.createObjectURL(file);
      this.$router.push({name : 'About', params: {url: this.url}})
    },
    refresh: async function () {
      const res = await axios.get('http://localhost:8080/')
      this.images = res.data.images
    },
  }
}

</script>

<style scoped>
    .loading_body {
      height: 300px;
      display: flex;
      justify-content: center;
      align-items: center;
    }
    .upload_body {
      height: 600px;
      display: flex;
      justify-content: center;
      align-items: center;
    }
    .background_loading_area {
      height: 40%;
      width: 50%;
      border-width: 1px;
      border-style: solid;
      border-color: rgb(238, 238, 238);
      border-image: initial;
      border-radius: 15px;
      box-shadow: rgba(0, 0, 0, 0.2) 0px 2px 12px 0px;
    }
    .background_upload_area {
      height: 90%;
      width: 50%;
      border-width: 1px;
      border-style: solid;
      border-color: rgb(238, 238, 238);
      border-image: initial;
      border-radius: 15px;
      box-shadow: rgba(0, 0, 0, 0.2) 0px 2px 12px 0px;
    }
    .drop_area {
        color: gray;
        background-color: rgb(236, 245, 255);
        font-weight: bold;
        font-size: 1.2em;
        display: flex;
        flex-flow: column;
        justify-content: center;
        align-items: center;
        width: 60%;
        height: 50%;
        border: 5px solid rgb(140, 197, 255);
        border-radius: 15px;
        margin: 0 auto;
    }
    .enter {
    border: 10px dotted rgb(140, 197, 255);
    }
    .title_font {
      font-size: 30px;
      font-weight: bold;
    }
</style>;