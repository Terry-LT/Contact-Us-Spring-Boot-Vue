<template>
  <nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Company Name</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <router-link class="nav-link active" :to="{'name':'home'}">Home</router-link>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#about_us">About Us</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#why_choose_us">Why Choose [Company Name]?</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#contact_us">Contact Us</a>
        </li>
        
      </ul>
    </div>
  </div>
</nav>
<ToastMessage />
<div class="container">
  <router-view/>
</div>
</template>
<script>
import ToastMessage from './components/ToastMessage.vue';
export default {
  components:{
    ToastMessage
  }
}
</script>

