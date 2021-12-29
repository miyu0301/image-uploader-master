<template>
  <!-- <div class="about">
    <h1>This is an about page</h1>
  </div> -->
  <div>
    <label>Uploaded Successfully!</label>
    <div v-if="url">
      <img :src="url">
      <input v-model="url" />
      <button @click="copyLink(url)">CopyLink</button>
    </div>
  </div>

</template>

<script>
export default {

  name: "ImagePage",
  props: ['url'],
  data () {
    return {
    }
  },
  methods: {
    copyLink: function(url) {
      navigator.clipboard.writeText(url)
    }
  }
}

</script>

