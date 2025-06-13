<script setup lang="ts">
import { ref } from 'vue'

const information = ref('placeholder')

const fetchInformation = () => {
  fetch('http://localhost:3000/api/ping')
    .then((response) => response.json())
    .then((json) => {
      information.value = json.msg
    })
}
</script>

<template>
  <button
    @click="fetchInformation"
    class="cursor-pointer border-2 border-solid border-cyan-600 px-3 py-2 bg-cyan-600 active:bg-cyan-700 transition-all text-gray-50 rounded"
  >
    fetch information
  </button>
  <p>{{ information }}</p>
</template>
