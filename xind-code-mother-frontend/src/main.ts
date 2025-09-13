/*
 * @Author: zhandmbx zhandmbx@163.com
 * @Date: 2025-09-13 16:02:26
 * @LastEditors: zhandmbx zhandmbx@163.com
 * @LastEditTime: 2025-09-13 16:13:03
 * @FilePath: \xind-code-mother-frontend\src\main.ts
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */


import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'
import router from './router'

import Antd from 'ant-design-vue'
import 'ant-design-vue/dist/reset.css'

const app = createApp(App)

app.use(createPinia())
app.use(router)
app.use(Antd)

app.mount('#app')
