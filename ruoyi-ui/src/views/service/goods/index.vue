<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="商品名称" prop="goodsName">
        <el-input
          v-model="queryParams.goodsName"
          placeholder="请输入商品名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="商品类型" prop="goodsType">
        <el-select v-model="queryParams.goodsType" placeholder="请选择商品类型" clearable>
          <el-option
            v-for="dict in dict.type.goods_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="供应商" prop="goodsContact">
        <el-input
          v-model="queryParams.goodsContact"
          placeholder="请输入供应商"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="进货时间" prop="goodsCreatetime">
        <el-date-picker clearable
          v-model="queryParams.goodsCreatetime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择进货时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['service:goods:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['service:goods:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['service:goods:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['service:goods:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="goodsList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="序号" align="center" prop="goodsId" />
      <el-table-column label="商品名称" align="center" prop="goodsName" />
      <el-table-column label="商品类型" align="center" prop="goodsType">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.goods_type" :value="scope.row.goodsType"/>
        </template>
      </el-table-column>
      <el-table-column label="商品图片" align="center" prop="goodsImg" width="100">
        <template slot-scope="scope">
          <image-preview :src="scope.row.goodsImg" :width="50" :height="50"/>
        </template>
      </el-table-column>
      <el-table-column label="供应商" align="center" prop="goodsContact" />
      <el-table-column label="单位" align="center" prop="goodsUnits" />
      <el-table-column label="库存数量" align="center" prop="goodsNum" />
      <el-table-column label="进价" align="center" prop="goodsPrice" />
      <el-table-column label="总计" align="center" prop="goodsTotalPrice" />
      <el-table-column label="用法用量" align="center" prop="dosage" />
      <el-table-column label="适用农作物" align="center" prop="crops" />
      <el-table-column label="针对疾病种类" align="center" prop="ills" />
      <el-table-column label="进货时间" align="center" prop="goodsCreatetime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.goodsCreatetime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['service:goods:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['service:goods:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改库存信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="100px">
        <el-form-item label="商品名称" prop="goodsName">
          <el-input v-model="form.goodsName" placeholder="请输入商品名称" />
        </el-form-item>
        <el-form-item label="商品类型" prop="goodsType">
          <el-select v-model="form.goodsType" placeholder="请选择商品类型">
            <el-option
              v-for="dict in dict.type.goods_type"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="商品图片" prop="goodsImg">
          <image-upload v-model="form.goodsImg"/>
        </el-form-item>
        <el-form-item label="供应商" prop="goodsContact">
          <el-input v-model="form.goodsContact" placeholder="请输入供应商" />
        </el-form-item>
        <el-form-item label="单位" prop="goodsUnits">
          <el-input v-model="form.goodsUnits" placeholder="请输入单位" />
        </el-form-item>
        <el-form-item label="库存数量" prop="goodsNum">
          <el-input v-model="form.goodsNum" placeholder="请输入库存数量" />
        </el-form-item>
        <el-form-item label="进价" prop="goodsPrice">
          <el-input v-model="form.goodsPrice" placeholder="请输入进价" />
        </el-form-item>
        <el-form-item label="用法用量" prop="dosage">
          <el-input v-model="form.dosage" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="适用农作物" prop="crops">
          <el-input v-model="form.crops" placeholder="请输入适用农作物" />
        </el-form-item>
        <el-form-item label="针对疾病种类" prop="ills">
          <el-input v-model="form.ills" placeholder="请输入针对疾病种类" />
        </el-form-item>
        <el-form-item label="进货时间" prop="goodsCreatetime">
          <el-date-picker clearable
            v-model="form.goodsCreatetime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择进货时间">
          </el-date-picker>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listGoods, getGoods, delGoods, addGoods, updateGoods } from "@/api/service/goods";

export default {
  name: "Goods",
  dicts: ['goods_type'],
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 库存信息表格数据
      goodsList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        goodsName: null,
        goodsType: null,
        goodsContact: null,
        goodsCreatetime: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        goodsName: [
          { required: true, message: "商品名称不能为空", trigger: "blur" }
        ],
        goodsUnits: [
          { required: true, message: "单位不能为空", trigger: "blur" }
        ],
        goodsNum: [
          { required: true, message: "库存数量不能为空", trigger: "blur" }
        ],
        goodsPrice: [
          { required: true, message: "进价不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询库存信息列表 */
    getList() {
      this.loading = true;
      listGoods(this.queryParams).then(response => {
        this.goodsList = response.rows;
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
        goodsId: null,
        goodsName: null,
        goodsType: null,
        goodsImg: null,
        goodsContact: null,
        goodsUnits: null,
        goodsNum: null,
        goodsPrice: null,
        goodsTotalPrice: null,
        dosage: null,
        crops: null,
        ills: null,
        goodsCreatetime: null
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
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.goodsId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加库存信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const goodsId = row.goodsId || this.ids
      getGoods(goodsId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改库存信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.goodsId != null) {
            updateGoods(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addGoods(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const goodsIds = row.goodsId || this.ids;
      this.$modal.confirm('是否确认删除库存信息编号为"' + goodsIds + '"的数据项？').then(function() {
        return delGoods(goodsIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('service/goods/export', {
        ...this.queryParams
      }, `goods_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
