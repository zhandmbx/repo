<!--
 * @Author: zhandmbx zhandmbx@163.com
 * @Date: 2025-09-13 16:44:48
 * @LastEditors: zhandmbx zhandmbx@163.com
 * @LastEditTime: 2025-09-15 23:02:37
 * @FilePath: \xind-code-mother-frontend\src\components\GlobalHeader.vue
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
-->
<template>
    <a-layout-header class="header">
      <a-row :wrap="false">
        <!-- 左侧：Logo和标题 -->
        <a-col flex="200px">
          <RouterLink to="/">
            <div class="header-left">
              <img class="logo" src="@/assets/logo.png" alt="Logo" />
              <h1 class="site-title">小马哥应用生成</h1>
            </div>
          </RouterLink>
        </a-col>
        <!-- 中间：导航菜单 -->
        <a-col flex="auto">
          <a-menu
            v-model:selectedKeys="selectedKeys"
            mode="horizontal"
            :items="menuItems"
            @click="handleMenuClick"
          />
        </a-col>
        <!-- 右侧：用户操作区域 -->
        <a-col>
            <div class="user-login-status">
                <div v-if="loginUserStore.loginUser.id">
                <a-dropdown>
                    <a-space>
                    <a-avatar :src="loginUserStore.loginUser.userAvatar" />
                    {{ loginUserStore.loginUser.userName ?? '无名' }}
                    </a-space>
                    <template #overlay>
                    <a-menu>
                        <a-menu-item @click="doLogout">
                        <LogoutOutlined />
                        退出登录
                        </a-menu-item>
                    </a-menu>
                    </template>
                </a-dropdown>
                </div>
                <div v-else>
                    <a-button type="primary" href="/user/login">登录</a-button>
                </div>
            </div>

                
            
        </a-col>
      </a-row>
    </a-layout-header>
    
  </template>
  
  <script setup lang="ts">
  import { computed, h, ref } from 'vue'
  import { useRouter } from 'vue-router'
  import type { MenuProps } from 'ant-design-vue'
  import { HomeOutlined, LogoutOutlined } from '@ant-design/icons-vue'

    // 用户注销
    const doLogout = async () => {
    const res = await userLogout()
    if (res.data.code === 0) {
        loginUserStore.setLoginUser({
        userName: '未登录',
        })
        message.success('退出登录成功')
        await router.push('/user/login')
    } else {
        message.error('退出登录失败，' + res.data.message)
    }
}

    // JS 中引入 Store 
  import { useLoginUserStore } from '@/stores/loginUser.ts'
import { userLogout } from '@/api/userController'
  const loginUserStore = useLoginUserStore()

  const router = useRouter()
  // 当前选中菜单
  const selectedKeys = ref<string[]>(['/'])
  // 监听路由变化，更新当前选中菜单
  router.afterEach((to, from, next) => {
    selectedKeys.value = [to.path]
  })
  
  
  
// 菜单配置项
const originItems = [
  {
    key: '/',
    icon: () => h(HomeOutlined),
    label: '主页',
    title: '主页',
  },
  {
    key: '/admin/userManage',
    label: '用户管理',
    title: '用户管理',
  },
  {
    key: 'others',
    label: h('a', { href: 'https://www.codefather.cn', target: '_blank' }, '编程导航'),
    title: '编程导航',
  },
]

// 过滤菜单项
const filterMenus = (menus = [] as MenuProps['items']) => {
  return menus?.filter((menu) => {
    const menuKey = menu?.key as string
    if (menuKey?.startsWith('/admin')) {
      const loginUser = loginUserStore.loginUser
      if (!loginUser || loginUser.userRole !== 'admin') {
        return false
      }
    }
    return true
  })
}

// 展示在菜单的路由数组
const menuItems = computed<MenuProps['items']>(() => filterMenus(originItems))


  // 处理菜单点击
  const handleMenuClick: MenuProps['onClick'] = (e) => {
    const key = e.key as string
    selectedKeys.value = [key]
    // 跳转到对应页面
    if (key.startsWith('/')) {
      router.push(key)
    }
  }
  </script>
  
  <style scoped>
  .header {
    background: #fff;
    padding: 0 24px;
  }
  
  .header-left {
    display: flex;
    align-items: center;
    gap: 12px;
  }
  
  .logo {
    height: 48px;
    width: 48px;
  }
  
  .site-title {
    margin: 0;
    font-size: 18px;
    color: #1890ff;
  }
  
  .ant-menu-horizontal {
    border-bottom: none !important;
  }
  </style>
  