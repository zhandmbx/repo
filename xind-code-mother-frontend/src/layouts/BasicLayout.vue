<!--
 * @Author: zhandmbx zhandmbx@163.com
 * @Date: 2025-09-13 16:45:59
 * @LastEditors: zhandmbx zhandmbx@163.com
 * @LastEditTime: 2025-09-13 16:52:51
 * @FilePath: \xind-code-mother-frontend\src\layouts\BasicLayout.vue
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE


 
-->
<template>
    <a-layout class="basic-layout">
      <!-- 顶部导航栏 -->
      <GlobalHeader />
  
      <!-- 主要内容区域 -->
      <a-layout-content class="main-content">
        <router-view />
      </a-layout-content>
  
      <!-- 底部版权信息 -->
      <GlobalFooter />
    </a-layout>
  </template>
  
  <script setup lang="ts">
  import GlobalHeader from '@/components/GlobalHeader.vue'
  import GlobalFooter from '@/components/GlobalFooter.vue'
  </script>
  
  <style scoped>
  .basic-layout {
    background: none;
  }
  
  .main-content {
    max-width: 1200px;
    padding: 24px;
    background: white;
    margin: 16px auto 56px;
  }
  </style>
  