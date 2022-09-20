const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  configureWebpack: {
    // provide the app's title in webpack's name field, so that
    // it can be accessed in index.html to inject the correct title.
    resolve: {
      fallback: { path: require.resolve("path-browserify") },
    },
  },
  transpileDependencies: true,
  lintOnSave: false,
  devServer: {
    port: 3000,
    proxy: {
      '/api': {
        target: 'http://124.221.159.221:8080',
        changeOrigin: true,
        pathRewrite: {
          '^/api': ''
        }
      }
    }
  }
})
