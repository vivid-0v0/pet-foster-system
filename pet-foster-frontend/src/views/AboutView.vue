<template>
  <div class="about-page">
    <div class="about-header">
      <h1>关于我们</h1>
      <p>用心守护每一位毛孩子的寄养时光</p>
    </div>
    
    <div class="about-content">
      <!-- 品牌介绍 -->
      <div class="about-card">
        <div class="card-img">
          <!-- 替换为真实图片 -->
          <img src="@/assets/images/about-brand.png" alt="品牌形象" />
        </div>
        <div class="card-text">
          <h2>品牌理念</h2>
          <p>我们成立于2020年，专注于宠物寄养服务，致力于为宠物提供安全、舒适、温馨的临时家园。</p>
          <p>我们的团队由专业的宠物护理师、兽医顾问组成，秉持“宠物至上”的理念，让每一位铲屎官安心托付。</p>
        </div>
      </div>
      
      <!-- 服务优势 -->
      <div class="about-card reverse">
        <div class="card-text">
          <h2>核心优势</h2>
          <ul>
            <li>✅ 1对1专属看护，每日互动时长≥2小时</li>
            <li>✅ 24小时实时监控，随时查看宠物状态</li>
            <li>✅ 科学喂养，严格遵循宠物饮食习惯</li>
            <li>✅ 就近合作宠物医院，应急保障</li>
            <li>✅ 每日发送宠物动态，让您放心</li>
          </ul>
        </div>
        <div class="card-img">
          <!-- 替换为真实图片 -->
          <img src="@/assets/images/about-advantage.png" alt="服务优势" />
        </div>
      </div>
      
      <!-- 环境展示 -->
      <div class="about-card">
        <div class="card-img">
          <!-- 替换为真实图片 -->
          <img src="@/assets/images/about-environment.png" alt="寄养环境" />
        </div>
        <div class="card-text">
          <h2>寄养环境</h2>
          <p>我们拥有独立的宠物活动空间，分区管理猫狗，避免冲突。</p>
          <p>环境每日清洁消毒，配备恒温空调、空气净化器，定期紫外线杀菌，确保宠物居住环境安全卫生。</p>
        </div>
      </div>
      
      <!-- 联系我们 -->
      <div class="contact-card">
        <h2>联系我们</h2>
        <div class="contact-info">
          <div class="contact-item">
            <i class="el-icon-location"></i>
            <div>
              <h3>地址</h3>
              <p>北京市朝阳区宠物友好大厦1008室</p>
            </div>
          </div>
          <div class="contact-item">
            <i class="el-icon-phone"></i>
            <div>
              <h3>电话</h3>
              <p>400-888-9999</p>
            </div>
          </div>
          <div class="contact-item">
            <i class="el-icon-message"></i>
            <div>
              <h3>微信</h3>
              <p>pet-care-2025</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
// 仅装饰性页面，无业务逻辑
</script>

<style scoped>
.about-page {
  padding: 20px;
  max-width: 1000px;
  margin: 0 auto;
  min-height: 80vh;
  background-color: #fffaf0; /* 统一温馨淡黄色背景 */
}
.about-header {
  text-align: center;
  margin-bottom: 40px;
}
.about-header h1 {
  font-size: 32px;
  color: #8b78e6;
  margin-bottom: 10px;
}
.about-header p {
  color: #666;
  font-size: 16px;
}
.about-content {
  display: flex;
  flex-direction: column;
  gap: 40px;
}
.about-card {
  display: flex;
  gap: 30px;
  align-items: center;
  background: white;
  padding: 30px;
  border-radius: 20px;
  box-shadow: 0 4px 12px rgba(0,0,0,0.1);
}
.about-card.reverse {
  flex-direction: row-reverse;
}
.card-img {
  width: 40%;
  height: 300px;
  border-radius: 16px;
  overflow: hidden;
}
/* 图片自适应容器 */
.card-img img {
  width: 100%;
  height: 100%;
  object-fit: cover; /* 保持比例填充，避免变形 */
}
.card-text {
  flex: 1;
}
.card-text h2 {
  color: #333;
  font-size: 22px;
  margin-bottom: 15px;
  position: relative;
  padding-bottom: 10px;
}
.card-text h2::after {
  content: '';
  position: absolute;
  left: 0;
  bottom: 0;
  width: 50px;
  height: 3px;
  background: #8b78e6;
}
.card-text p {
  color: #666;
  line-height: 1.8;
  margin-bottom: 10px;
}
.card-text ul {
  list-style: none;
  padding: 0;
}
.card-text li {
  color: #666;
  line-height: 2;
}
.contact-card {
  background: white;
  padding: 30px;
  border-radius: 20px;
  box-shadow: 0 4px 12px rgba(0,0,0,0.1);
}
.contact-card h2 {
  color: #333;
  font-size: 22px;
  margin-bottom: 20px;
  text-align: center;
}
.contact-info {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
  gap: 20px;
}
.contact-item {
  display: flex;
  align-items: center;
  gap: 15px;
  padding: 15px;
  border-radius: 10px;
  background: #f8f9fa;
}
.contact-item i {
  font-size: 24px;
  color: #8b78e6;
  width: 40px;
  height: 40px;
  display: flex;
  align-items: center;
  justify-content: center;
  background: white;
  border-radius: 50%;
  box-shadow: 0 2px 8px rgba(0,0,0,0.1);
}
.contact-item h3 {
  color: #333;
  font-size: 16px;
  margin-bottom: 5px;
}
.contact-item p {
  color: #666;
  font-size: 14px;
}

/* 响应式适配 */
@media (max-width: 768px) {
  .about-card, .about-card.reverse {
    flex-direction: column;
  }
  .card-img {
    width: 100%;
    height: 200px;
  }
}
</style>