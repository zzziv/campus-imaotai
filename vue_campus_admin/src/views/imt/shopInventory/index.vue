<template>
  <div class="app-container">
    <el-form
      :model="queryParams"
      ref="queryForm"
      size="small"
      :inline="true"
      v-show="showSearch"
      label-width="68px"
    >

      <el-form-item label="商品" prop="itemCode">
        <el-select v-model="queryParams.itemCode" placeholder="选择商品" clearable>
          <el-option
            v-for="item in itemList"
            :key="item.itemCode"
            :label="item.title"
            :value="item.itemCode"
          />
        </el-select>
      </el-form-item>


      <el-form-item label="省份" prop="provinceName">
        <el-input
          v-model="queryParams.provinceName"
          placeholder="请输入省份"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="店铺ID" prop="ishopId">
        <el-input
          v-model="queryParams.ishopId"
          placeholder="请输入店铺ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button
          type="primary"
          icon="el-icon-search"
          size="mini"
          @click="handleQuery"
          >搜索</el-button
        >
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery"
          >重置</el-button
        >
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-refresh"
          size="mini"
          @click="handleRefresh"
          >刷新i茅台商品列表</el-button
        >
      </el-col>
      <right-toolbar
        :showSearch.sync="showSearch"
        @queryTable="getList"
      ></right-toolbar>
    </el-row>

    <el-table
      v-loading="loading"
      :data="shopList"
    >
      <el-table-column label="店铺ID" align="center" prop="ishopId" />
      <el-table-column label="省份" align="center" prop="provinceName" />
      <el-table-column label="城市" align="center" prop="cityName" />
      <el-table-column label="地区" align="center" prop="districtName" />
      <el-table-column label="店铺名称" align="center" prop="name" />
      <el-table-column label="公司名称" align="center" prop="tenantName" />
      <el-table-column label="商品名称" align="center" prop="title" />
      <el-table-column label="图片" align="center" prop="picture">
        <template slot-scope="scope">
          <el-image
            style="width: 50px; "
            :src="scope.row.picture"
            fit="fit"
          ></el-image>
        </template>
      </el-table-column>
      <el-table-column label="库存" align="center" prop="inventory" />
      <el-table-column label="最大储备数量" align="center" prop="maxReserveCount" />
      <el-table-column label="默认储备数量" align="center" prop="defaultReserveCount" />
    </el-table>

    <pagination
      v-show="total > 0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />
  </div>
</template>

<script>
import {inventory, listShop, refreshShop} from "@/api/imt/shop";
import {listItem} from "@/api/imt/item";

export default {
  name: "Shop",
  data() {
    return {
      // 遮罩层
      loading: true,

      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // i茅台商品表格数据
      shopList: [],
      // i茅台商品列表
      itemList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        iShopId: null,
        provinceName: null,
        cityName: null,
        districtName: null,
        fullAddress: null,
        lat: null,
        lng: null,
        name: null,
        tenantName: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {},
    };
  },
  created() {
    this.getList();
    this.getItemList();
  },
  methods: {
    /** 查询i茅台商品列表 */
    getList() {
      this.loading = true;
      inventory(this.queryParams).then((response) => {
        this.shopList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        shopId: null,
        iShopId: null,
        provinceName: null,
        cityName: null,
        districtName: null,
        fullAddress: null,
        lat: null,
        lng: null,
        name: null,
        tenantName: null,
        createTime: null,
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },

    handleRefresh() {
      refreshShop().then(() => {
        this.getList();
        this.$modal.msgSuccess("刷新成功");
      });
    },
    getItemList() {
      listItem().then((response) => {
        this.itemList = response.data;
      });
    }
  },
};
</script>
