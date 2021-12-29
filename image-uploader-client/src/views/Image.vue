<template id='app'>
    <el-row>
    <div v-show="isLoading">
      <label>Uploading...</label>
      <template>
        <div class="container">
          <vue-loading type="spin" color="#333" :size="{ width: '50px', height: '50px' }"></vue-loading>
        </div>
      </template>
    </div>
    <div v-show="!isLoading">
      <label>ファイルを選択
          <input @change="changeFile" ref="file" type="file">
      </label>
      <el-row>
          <el-col :span="24">
              <el-card class="box-card">
                  <div slot="header" class="clearfix">
                      <span>test</span>
                  </div>
                  <el-table
                          :data="images"
                          style="width: 100%">
                      <el-table-column
                              prop="id"
                              label="id"
                              width="300"/>
                      <el-table-column
                              prop="image_name"
                              label="image_name"
                              width="300"/>
                      <el-table-column
                              prop="image_data"
                              label="image_data"
                              width="300"/>
                      <el-table-column
                              prop="ins_datetime"
                              label="ins_datetime"
                              width="300"/>
                  </el-table>
              </el-card>
          </el-col>
      </el-row>
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
        isLoading: false,
        url: "",
    }
  },
  created: async function () {
    await this.refresh()
  },
  methods: {
    changeFile: async function (e) {

      this.isLoading = true
      const _sleep = (ms) => new Promise((resolve) => setTimeout(resolve, ms));
      await _sleep(2000);
      
      const files = e.target.files || e.dataTransfer.files

      let file_name = files[0].name;

      let reader = new FileReader();
      reader.readAsBinaryString(e.target.files[0]);
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
        // console.info('bbb');
        // console.info(e.target);
        // console.info(e.target.result);
      };
      console.info('ccc')


      // show image
      this.url = URL.createObjectURL(files[0]);

      this.$router.push({name : 'About', params: {url: this.url}})
      console.info('ddd')


      await this.refresh()
    },
    refresh: async function () {
      const res = await axios.get('http://localhost:8080/')
      this.images = res.data.images
      // console.info(this.images)
    },
  }
}

</script>

<style scoped>

</style>;