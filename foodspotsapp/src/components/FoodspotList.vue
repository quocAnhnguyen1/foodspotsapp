<script setup lang="ts">
import {onMounted, ref, type Ref} from "vue";

defineProps<{ title: string }>()
type Foodspot = { id: number; name: string }

const foodspots: Ref<Foodspot[]> = ref([])
const nameField = ref("")
let currentId = 1

function initFoodspots(): void {
  addFoodspot('Calm Coffee')
  addFoodspot('Ikigai Teabar')
}

function addFoodspot(name: string): void {
  foodspots.value.push({name, id: currentId++})
}

function onFormSubmitted(): void {
  addFoodspot(nameField.value)
}

function removeFoodspot(id: number): void {
  foodspots.value = foodspots.value.filter((f) => f.id !== id)
}

onMounted(() => {
  initFoodspots()
})
</script>

<template>
  <h2>{{ title }}</h2>
  <form @submit="onFormSubmitted()" @submit.prevent>
    <input type="text" placeholder="Name" v-model="nameField"/>
    <button>Add foodspot</button>
  </form>
  <hr/>
  <table>
    <tr>
      <th>Delete</th>
      <th>Name</th>
      <th>Id</th>
    </tr>
    <tr v-if="!foodspots.length">
      <td colspan="2">No foodspots yet</td>
    </tr>
    <tr v-for="foodspot in foodspots" :key="foodspot.id">
      <td>
        <button @click="removeFoodspot(foodspot.id)" class="delete">delete</button>
      </td>
      <td>{{ foodspot.name }}</td>
      <td>{{ foodspot.id }}</td>
    </tr>
  </table>
</template>
