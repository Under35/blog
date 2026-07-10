# 🎨 设计系统实施清单

## 项目开发阶段清单

### 项目初始化 ✓

- [ ] 复制 `DESIGN_SYSTEM.md` 到项目文档
- [ ] 创建 `styles/design-system.css` (CSS变量文件)
- [ ] 或创建 `styles/_variables.scss` (SCSS变量文件)
- [ ] 在主项目中导入设计系统文件
- [ ] 配置 CSS 预处理器（如需要）
- [ ] 在 `.gitignore` 中配置必要项

### 颜色系统 ✓

- [ ] 使用 `--color-primary-*` 变量作为主色
- [ ] 使用 `--color-neutral-*` 变量作为中立色
- [ ] 使用 `--color-success-*` 表示成功状态
- [ ] 使用 `--color-warning-*` 表示警告状态
- [ ] 使用 `--color-error-*` 表示错误状态
- [ ] 使用 `--color-info-*` 表示信息状态
- [ ] 所有颜色通过 CSS 变量定义（禁止硬编码）
- [ ] 测试颜色对比度 ≥ WCAG AA（4.5:1 为小文本）

### 排版系统 ✓

- [ ] 使用 `--font-family-sans` 作为主字体
- [ ] 使用 `--font-family-mono` 作为代码字体
- [ ] 标题使用 `--font-size-title-*` 系列
- [ ] 正文使用 `--font-size-body` (14px)
- [ ] 小文本使用 `--font-size-small` (12px)
- [ ] 字重使用预定义的 `--font-weight-*`
- [ ] 行高遵循 `--line-height-*` 规范
- [ ] 避免自定义字体大小值

### 间距系统 ✓

- [ ] 所有 padding 使用 `--spacing-*` 变量
- [ ] 所有 margin 使用 `--spacing-*` 变量
- [ ] gap 属性使用间距变量
- [ ] 禁止硬编码像素值（除特殊情况）
- [ ] 间距规则：从 4px 到 64px 的阶梯式

### 圆角系统 ✓

- [ ] 按钮使用 `--border-radius-md` (6px)
- [ ] 卡片使用 `--border-radius-lg` (8px)
- [ ] 输入框使用 `--border-radius-md` (6px)
- [ ] 大组件使用 `--border-radius-xl` (12px)
- [ ] 禁止随意设置 border-radius

### 阴影系统 ✓

- [ ] 卡片默认使用 `--shadow-md`
- [ ] 悬停状态升级到 `--shadow-lg`
- [ ] 模态框使用 `--shadow-xl`
- [ ] 禁止自定义 box-shadow 值

### 动画过渡 ✓

- [ ] 快速交互使用 `--transition-fast` (150ms)
- [ ] 常规过渡使用 `--transition-normal` (200ms)
- [ ] 缓慢过渡使用 `--transition-slow` (300ms)
- [ ] easing 函数使用 `cubic-bezier(0.4, 0, 0.2, 1)`
- [ ] 提供 `prefers-reduced-motion` 支持

---

## 组件开发清单

### 按钮组件 ✓

- [ ] 实现 Primary（主色）变体
- [ ] 实现 Secondary（副色）变体
- [ ] 实现 Ghost（幽灵）变体
- [ ] 实现 Danger（危险）变体（可选）
- [ ] 提供 Small、Medium、Large 三种尺寸
- [ ] 实现 disabled 状态
- [ ] 实现 loading 状态（可选）
- [ ] 添加 focus 焦点指示器
- [ ] 最小尺寸 44×44px（可点击区域）
- [ ] 支持 <button> 和 <a> 标签
- [ ] 支持图标 + 文本组合
- [ ] 编写完整的 JSDoc/TypeScript 类型

### 输入框组件 ✓

- [ ] 文本输入框 (<input type="text">)
- [ ] 邮箱输入框 (<input type="email">)
- [ ] 密码输入框 (<input type="password">)
- [ ] 数字输入框 (<input type="number">)
- [ ] 搜索输入框 (<input type="search">)
- [ ] 实现 focus 状态
- [ ] 实现 error 状态
- [ ] 实现 disabled 状态
- [ ] 实现 placeholder 文本
- [ ] 最小高度 44px（移动友好）
- [ ] 包含 label 关联
- [ ] 包含 helper text / error message

### 选择框 ✓

- [ ] <select> 下拉框
- [ ] 自定义样式覆盖浏览器默认
- [ ] 多选 <select multiple>
- [ ] Radio 按钮组
- [ ] Checkbox 复选框
- [ ] Toggle 切换开关
- [ ] focus 和 disabled 状态
- [ ] 键盘导航支持

### 卡片组件 ✓

- [ ] 基础卡片结构
- [ ] 卡片头部（header）
- [ ] 卡片内容（content）
- [ ] 卡片底部（footer）
- [ ] 悬停效果（lift up）
- [ ] 响应式宽度
- [ ] 图片支持
- [ ] 操作按钮区域

### 警告/提示框 ✓

- [ ] Success alert（绿色）
- [ ] Warning alert（橙色）
- [ ] Error alert（红色）
- [ ] Info alert（蓝色）
- [ ] 可关闭的提示框
- [ ] 图标 + 文本结构
- [ ] 支持多行文本
- [ ] ARIA role="alert"

### 模态框/对话框 ✓

- [ ] 模态框背景（scrim）
- [ ] 模态框容器
- [ ] 标题、内容、操作区
- [ ] 关闭按钮
- [ ] ESC 键关闭
- [ ] 焦点陷阱（focus trap）
- [ ] 动画进出效果
- [ ] 响应式尺寸

### 加载状态 ✓

- [ ] 加载转圈（spinner）
- [ ] 骨架屏（skeleton）
- [ ] 进度条（progress bar）
- [ ] 脉冲动画（pulse）
- [ ] 自定义颜色支持

### 分页组件 ✓

- [ ] 前一页/后一页按钮
- [ ] 页码列表
- [ ] 当前页高亮
- [ ] disabled 状态
- [ ] 页码省略号
- [ ] 跳转输入框
- [ ] 每页条数选择

---

## 响应式设计清单

### 断点测试 ✓

- [ ] XS (320px) - 小手机
- [ ] SM (640px) - 大手机
- [ ] MD (1024px) - 平板
- [ ] LG (1440px) - 桌面
- [ ] XL (1920px) - 超宽屏

### 移动优化 ✓

- [ ] 触摸目标最小 44×44px
- [ ] 按钮间距最小 8px
- [ ] 字体大小不小于 12px
- [ ] 禁用缩放 (user-scalable=yes)
- [ ] 视口元标签正确配置
- [ ] 避免水平滚动
- [ ] 堆叠布局（单列）
- [ ] 移动设备实机测试

### 平板适配 ✓

- [ ] 两列布局测试
- [ ] 触摸交互验证
- [ ] 横屏/竖屏切换
- [ ] 键盘 + 触摸混合

### 桌面适配 ✓

- [ ] 多列布局
- [ ] 悬停效果正常
- [ ] 鼠标交互
- [ ] 宽屏利用

---

## 可访问性清单

### 颜色和对比度 ✓

- [ ] 文本对比度 ≥ 4.5:1（WCAG AA）
- [ ] 大文本对比度 ≥ 3:1（WCAG AA）
- [ ] 按钮/链接对比度 ≥ 3:1
- [ ] 使用 WebAIM Contrast Checker 验证
- [ ] 不仅依赖颜色传达信息
- [ ] 支持深色模式

### 焦点和键盘导航 ✓

- [ ] 所有可交互元素都有焦点指示
- [ ] 焦点顺序逻辑清晰（tab order）
- [ ] 焦点样式明显（2px outline）
- [ ] 焦点离对象不超过 2px
- [ ] 支持键盘快捷键
- [ ] ESC 键关闭模态框
- [ ] Enter 键激活按钮
- [ ] Space 键激活复选框

### HTML 语义化 ✓

- [ ] 使用正确的 heading 标签 (h1-h6)
- [ ] 使用 <button> 而非 <div>
- [ ] 使用 <a> 而非 <span>
- [ ] 使用 <label> 关联表单字段
- [ ] 使用列表标签 (<ul>, <ol>)
- [ ] 使用 <nav> 标记导航
- [ ] 使用 <main> 标记主内容
- [ ] 避免滥用 <div>

### ARIA 标签 ✓

- [ ] 按钮提供 aria-label（如仅有图标）
- [ ] 表单字段有关联的 <label>
- [ ] 动态内容有 aria-live
- [ ] 加载状态有 aria-busy
- [ ] 错误消息有 aria-describedby
- [ ] 模态框有 role="dialog"
- [ ] 提示框有 role="alert"

### 图片和媒体 ✓

- [ ] 所有图片有 alt 属性
- [ ] alt 文本清晰有意义
- [ ] 装饰图片用 alt="" 和 aria-hidden
- [ ] 视频有字幕/副标题
- [ ] 音频有文本转录

### 表单可访问性 ✓

- [ ] 每个输入框都有 <label>
- [ ] label 用 for 属性与 input id 关联
- [ ] 错误信息清晰可见
- [ ] 成功反馈明显
- [ ] 必填字段标记
- [ ] 验证实时反馈
- [ ] 支持自动填充

### 屏幕阅读器 ✓

- [ ] NVDA 测试（Windows）
- [ ] VoiceOver 测试（Mac/iOS）
- [ ] JAWS 测试（高端）
- [ ] axe DevTools 扫描
- [ ] WAVE 扫描
- [ ] 语义 HTML 结构清晰
- [ ] 跳过链接存在

---

## 深色模式清单

- [ ] 所有颜色在深色模式下都定义了
- [ ] 使用 `@media (prefers-color-scheme: dark)`
- [ ] 文本对比度在深色模式下也满足 WCAG
- [ ] 图片在深色模式下可见性正常
- [ ] 边框颜色在深色模式下清晰
- [ ] 动画效果在深色模式下正常
- [ ] 测试系统切换深色模式时的效果

---

## 浏览器兼容性清单

- [ ] Chrome (最新)
- [ ] Firefox (最新)
- [ ] Safari (最新 2 版本)
- [ ] Edge (最新)
- [ ] 移动 Safari (iOS)
- [ ] Chrome Mobile (Android)

**不支持的浏览器**:
- IE 11 及以下（不支持 CSS 变量）

---

## 文件组织结构

```
project/
├── styles/
│   ├── design-system.css       ← CSS 变量定义
│   ├── components/
│   │   ├── button.css
│   │   ├── input.css
│   │   ├── card.css
│   │   ├── alert.css
│   │   └── ...
│   ├── layout/
│   │   ├── grid.css
│   │   ├── container.css
│   │   └── ...
│   ├── utilities/
│   │   ├── spacing.css
│   │   ├── typography.css
│   │   └── ...
│   └── index.css               ← 合并所有样式
├── docs/
│   ├── DESIGN_SYSTEM.md        ← 设计规范
│   ├── DESIGN_CHECKLIST.md     ← 本文件
│   └── IMPLEMENTATION.md       ← 实现指南
└── components/
    ├── Button/
    │   ├── Button.jsx
    │   ├── Button.css
    │   ├── Button.test.js
    │   └── Button.stories.js   ← Storybook
    └── ...
```

---

## 验收标准

### 代码审查标准

- [ ] 使用了设计系统的所有颜色、间距、排版变量
- [ ] 没有硬编码的颜色值、尺寸值
- [ ] CSS 遵循 BEM 命名规范
- [ ] 没有全局样式污染
- [ ] 样式代码有注释说明复杂逻辑

### 视觉测试标准

- [ ] UI 与设计稿一致（±1px 误差）
- [ ] 所有状态都实现（hover, focus, active, disabled）
- [ ] 响应式布局在各断点都正确显示
- [ ] 深色模式与浅色模式一致
- [ ] 动画效果流畅（60fps）

### 可访问性测试标准

- [ ] Lighthouse Accessibility 评分 ≥ 95
- [ ] axe DevTools 无错误
- [ ] 键盘导航完全可用
- [ ] 屏幕阅读器可以访问所有内容

---

## 质量指标

| 指标 | 目标 | 工具 |
|------|------|------|
| Lighthouse Accessibility | ≥ 95 | Chrome DevTools |
| Contrast Ratio | WCAG AA | WebAIM |
| CSS 重复度 | < 5% | CSS Stats |
| 打包体积 | < 50KB | npm stats |
| 加载时间 | < 2s | PageSpeed |

---

## 维护和版本控制

### 版本号规则

使用语义化版本 (SemVer)：
- **主版本**: 重大 API 变化（如颜色系统重新设计）
- **次版本**: 新组件或新功能（向后兼容）
- **修订版本**: bug 修复（向后兼容）

### 更新流程

1. 在 CHANGELOG.md 记录所有变更
2. 更新版本号
3. 发布到 npm（如适用）
4. 通知所有项目升级
5. 提供迁移指南

---

## 常见问题解决

### 问题：颜色在深色模式下看不清

**解决**：检查 `--color-text-primary` 和 `--color-bg-primary` 的对比度，应满足 4.5:1

### 问题：焦点框在某些元素上看不见

**解决**：确保 `outline-color` 与背景颜色对比度足够，或增加 `outline-width`

### 问题：响应式断点处布局跳跃

**解决**：使用流体计算值 (`clamp()`) 代替硬断点

### 问题：iOS 上输入框太小

**解决**：确保字体大小 ≥ 16px，这样可以避免自动缩放

---

## 发布清单

部署前的最终检查：

- [ ] 所有代码审查注释已解决
- [ ] 单元测试通过率 ≥ 95%
- [ ] E2E 测试全部通过
- [ ] Lighthouse 评分检查
- [ ] 性能基准测试完成
- [ ] 安全扫描完成
- [ ] 文档已更新
- [ ] CHANGELOG 已更新
- [ ] 标签 (tag) 已创建
- [ ] 发行说明已准备

---

**检查日期**: ________________  
**检查人**: ________________  
**审核人**: ________________  
**发布状态**: ☐ 待发布 ☐ 已发布

---

**维护者**: Design System Team  
**最后更新**: 2026-07-10
