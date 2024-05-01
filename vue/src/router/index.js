import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

// 解决导航栏或者底部导航tabBar中的vue-router在3.0版本以上频繁点击菜单报错的问题。
const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push (location) {
  return originalPush.call(this, location).catch(err => err)
}

const routes = [
  {
    path: '/',
    name: 'Manager',
    component: () => import('../views/Manager.vue'),
    redirect: '/home',  // 重定向到主页
    children: [
      { path: '403', name: 'NoAuth', meta: { name: '无权限' }, component: () => import('../views/manager/403') },
      { path: 'home', name: 'Home', meta: { name: '系统首页' }, component: () => import('../views/manager/Home') },
      { path: 'admin', name: 'Admin', meta: { name: '管理员信息' }, component: () => import('../views/manager/Admin') },
      { path: 'adminPerson', name: 'AdminPerson', meta: { name: '个人信息' }, component: () => import('../views/manager/AdminPerson') },
      { path: 'password', name: 'Password', meta: { name: '修改密码' }, component: () => import('../views/manager/Password') },
      { path: 'notice', name: 'Notice', meta: { name: '公告信息' }, component: () => import('../views/manager/Notice') },
      { path: 'user', name: 'User', meta: { name: '用户信息' }, component: () => import('../views/manager/User') },
      { path: 'lost', name: 'Lost', meta: { name: '失物信息' }, component: () => import('../views/manager/Lost') },
      { path: 'find', name: 'Find', meta: { name: '招领信息' }, component: () => import('../views/manager/Find') },
      { path: 'suggestion', name: 'Suggestion', meta: { name: '用户建议' }, component: () => import('../views/manager/Suggestion') },
    ]
  },
  {
    path: '/front',
    name: 'Front',
    component: () => import('../views/Front.vue'),
    children: [
      { path: 'home', name: 'Home', meta: { name: '系统首页' }, component: () => import('../views/front/Home') },
      { path: 'person', name: 'Person', meta: { name: '个人信息' }, component: () => import('../views/front/Person') },
      { path: 'myLost', name: 'MyLost', meta: { name: '我的失物' }, component: () => import('../views/front/MyLost') },
      { path: 'lostSquare', name: 'LostSquare', meta: { name: '失物广场' }, component: () => import('../views/front/LostSquare') },
      { path: 'findSquare', name: 'FindSquare', meta: { name: '招领广场' }, component: () => import('../views/front/FindSquare') },
      { path: 'suggestion', name: 'Suggestion', meta: { name: '平台建议' }, component: () => import('../views/front/Suggestion') },
      { path: 'myFind', name: 'MyFind', meta: { name: '我的招领' }, component: () => import('../views/front/MyFind') },
      { path: 'toMe', name: 'ToMe', meta: { name: '联系我的' }, component: () => import('../views/front/ToMe') },
      { path: 'toOther', name: 'ToOther', meta: { name: '我联系的' }, component: () => import('../views/front/ToOther') },
      {path: 'chat',name:'Chat',meta:{name:'聊天信息'},component:()=>import('../views/front/Chat') },
      {path: 'news',name:'News',meta:{name:'校园资讯'},component:()=>import('../views/front/News') },
    ]
  },
  { path: '/login', name: 'Login', meta: { name: '登录' }, component: () => import('../views/Login.vue') },
  { path: '/register', name: 'Register', meta: { name: '注册' }, component: () => import('../views/Register.vue') },
  { path: '*', name: 'NotFound', meta: { name: '无法访问' }, component: () => import('../views/404.vue') },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

// 注：不需要前台的项目，可以注释掉该路由守卫
// 路由守卫
router.beforeEach((to ,from, next) => {
   let user = JSON.parse(localStorage.getItem("xm-user") || '{}');
   if (to.path === '/') {
     if (user.role) {
      if (user.role === 'USER') {
        next('/front/home')
       } else {
        next('/home')
       } } else {
      next('/login')
    }
  } else {
    next()
  }
 })

export default router
