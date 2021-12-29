<template>
  <div class="body">
    <div class="background_area">
    <el-result icon="success" />
      <p class="title_font">Uploaded Successfully!</p>
      <!-- <div v-if="url"> -->
        <img :src="url">
        <div class="input_area">
          <el-input v-model="url"/>
          <el-row>
            <el-button type="primary" @click="copyLink(url)">CopyLink</el-button>
          </el-row>
        </div>
      <!-- </div> -->
    </div>
  </div>

</template>

<script>
export default {
  props: ['url'],
  data () {
    return {
    }
  },
  created: function () {
    navigator.clipboard.writeText(this.url)
  },
  methods: {
    copyLink: function(url) {
      navigator.clipboard.writeText(url)
    }
  }
}

</script>
<style scoped>
  .body {
    height: 600px;
    display: flex;
    justify-content: center;
    align-items: center;
  }
  .background_area {
    height: 90%;
    width: 50%;
    border-width: 1px;
    border-style: solid;
    border-color: rgb(238, 238, 238);
    border-image: initial;
    border-radius: 15px;
    box-shadow: rgba(0, 0, 0, 0.2) 0px 2px 12px 0px;
    display: flex;
    flex-flow: column;
    justify-content: center;
    align-items: center;
  }
  .input_area {
    display: flex;
    width: 80%;
    margin: 10px;
  }

  .title_font {
    font-size: 30px;
    font-weight: bold;
    margin: 20px;
  }
  .el-result {
    padding: 10px;
  }
  img {
    height: 40%;
    border-radius: 15px;
    margin: 20px;
  }
</style>
